package co.crisi.shipm8.service;

import co.crisi.shipm8.domain.IOrder;
import co.crisi.shipm8.domain.data.Order;
import co.crisi.shipm8.domain.data.input.OrderSaveDto;
import co.crisi.shipm8.exception.business.AddressNotFoundException;
import co.crisi.shipm8.exception.business.BusinessException;
import co.crisi.shipm8.exception.business.OrderNotFoundException;
import co.crisi.shipm8.exception.business.ProductNotFoundException;
import co.crisi.shipm8.exception.business.RepeatedOrderException;
import co.crisi.shipm8.exception.business.ShopperNotFoundException;
import co.crisi.shipm8.port.api.IOrderServicePort;
import co.crisi.shipm8.port.spi.IAddressPersistencePort;
import co.crisi.shipm8.port.spi.IOrderPersistencePort;
import co.crisi.shipm8.port.spi.IProductPersistencePort;
import co.crisi.shipm8.port.spi.IShopperPersistencePort;
import io.vavr.control.Either;
import io.vavr.control.Try;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class OrderServicePort implements IOrderServicePort {

    private final IOrderPersistencePort persistencePort;

    private final IAddressPersistencePort addressPersistencePort;

    private final IProductPersistencePort productPersistencePort;

    private final IShopperPersistencePort shopperPersistencePort;

    @Override
    public IOrder save(IOrder entity) {
        //Everytime it processed the order, will have to send the message it was processed!x
        if (persistencePort.existsById(entity.getId())) {
            throw new RepeatedOrderException(String.format("The order with id %d already exists!", entity.getId()));
        }
        return persistencePort.save(entity);
    }

    @Override
    public IOrder getById(Long id) {
        return persistencePort.findById(id)
                .orElseThrow(() -> new OrderNotFoundException(String.format("The order %d was not found!", id)));
    }

    @Override
    public List<IOrder> getAll() {
        return persistencePort.findAll();
    }

    @Override
    public IOrder update(Long id, IOrder newInfo) {
        if (!persistencePort.existsById(id)) {
            throw new OrderNotFoundException(String.format("The order with id %d was not found!", id));
        }
        if (!id.equals(newInfo.getId())) {
            throw new BusinessException("Error in the body, the ids are not equal!");
        }
        return save(newInfo);
    }

    @Override
    public void deleteById(Long id) {
        if (!persistencePort.existsById(id)) {
            throw new OrderNotFoundException(String.format("The order with id %d was not found!", id));
        }
        persistencePort.deleteById(id);
    }

    @Override
    public IOrder save(OrderSaveDto order) {
        return (IOrder) validateShippingAddressesExistence(order)
                .flatMap(this::validateBillingAddressExistence)
                .flatMap(this::validateProductsExistence)
                .flatMap(this::validateShopperExistence)
                .flatMap(this::createOrder)
                .fold(Function.identity(), Function.identity());

    }

    private Either<BusinessException, OrderSaveDto> validateShippingAddressesExistence(OrderSaveDto order) {
        if (!addressPersistencePort.existsById(order.shippingAddressId())) {
            return Either.left(new AddressNotFoundException(
                    String.format("The address with id %d should exists!", order.billingAddressId())));
        }
        return Either.right(order);
    }

    private Either<BusinessException, OrderSaveDto> validateBillingAddressExistence(OrderSaveDto order) {
        if (!addressPersistencePort.existsById(order.billingAddressId())) {
            return Either.left(new AddressNotFoundException(
                    String.format("The address with id %d should exists!", order.billingAddressId())));
        }
        return Either.right(order);
    }

    private Either<BusinessException, OrderSaveDto> validateProductsExistence(OrderSaveDto order) {
        var nonExistentIds = order.productIds()
                .stream()
                .filter(id -> !productPersistencePort.existsById(id))
                .toList();
        if (!nonExistentIds.isEmpty()) {
            return Either.left(new ProductNotFoundException(
                    "The product ids " + nonExistentIds + " were not found!"));
        }

        return Either.right(order);
    }

    private Either<BusinessException, OrderSaveDto> validateShopperExistence(OrderSaveDto order) {
        return !shopperPersistencePort.existsById(order.shopperId())
                ? Either.left(
                new ShopperNotFoundException(String.format("The shopper with %d does not exists!", order.shopperId())))
                : Either.right(order);
    }

    private Either<BusinessException, Order> createOrder(OrderSaveDto order) {

        var shippingAddress = addressPersistencePort.findById(order.shippingAddressId()).orElseThrow();
        var billingAddress = addressPersistencePort.findById(order.billingAddressId()).orElseThrow();
        var shopper = shopperPersistencePort.findById(order.shopperId()).orElseThrow();
        var products = order.productIds().stream()
                .map(id -> productPersistencePort.findById(id).orElseThrow())
                .toList();

        return Try.of(() -> Order.builder()
                        .billingAddress(billingAddress)
                        .shippingAddress(shippingAddress)
                        .orderDate(order.orderDate())
                        .orderNotes(order.orderNotes())
                        .orderStatus(order.orderStatus())
                        .cancellationReason(order.cancellationReason())
                        .orderCompletionDate(order.orderCompletionDate())
                        .paymentMethod(order.paymentMethod())
                        .paymentStatus(order.paymentStatus())
                        .products(products)
                        .shippingMethod(order.shippingMethod())
                        .shopper(shopper)
                        .totalPrice(order.totalPrice())
                        .build())
                .toEither()
                .mapLeft(throwable -> new BusinessException(throwable.getMessage()));

    }


}
