package co.crisi.shipm8.domain.data;

import co.crisi.shipm8.domain.IAddress;
import co.crisi.shipm8.domain.IOrder;
import co.crisi.shipm8.domain.IProduct;
import co.crisi.shipm8.domain.IShopper;
import co.crisi.shipm8.domain.validator.decorator.DateValidatorDecorator;
import co.crisi.shipm8.domain.validator.decorator.NonEmptyCollectionValidatorDecorator;
import co.crisi.shipm8.domain.validator.decorator.NonNegativeNumberValidatorDecorator;
import co.crisi.shipm8.domain.validator.decorator.NonNullValidatorDecorator;
import co.crisi.shipm8.domain.validator.decorator.Validator;
import java.time.LocalDate;
import java.util.List;

public record Order(Long id, LocalDate orderDate, OrderStatus orderStatus, Double totalPrice, IAddress shippingAddress,
                    IAddress billingAddress, PaymentMethod paymentMethod, PaymentStatus paymentStatus,
                    ShippingMethod shippingMethod, String orderNotes, String cancellationReason,
                    LocalDate orderCompletionDate, List<IProduct> products, IShopper shopper) implements IOrder {

    public Order(Long id, LocalDate orderDate, OrderStatus orderStatus, Double totalPrice, IAddress shippingAddress,
            IAddress billingAddress, PaymentMethod paymentMethod, PaymentStatus paymentStatus,
            ShippingMethod shippingMethod,
            String orderNotes, String cancellationReason, LocalDate orderCompletionDate, List<IProduct> products,
            IShopper shopper) {
        var validator = new Validator();
        var nonNullValidator = new NonNullValidatorDecorator(validator);
        var dateValidator = new DateValidatorDecorator(nonNullValidator);
        var nonNegativeValidator = new NonNegativeNumberValidatorDecorator(nonNullValidator);
        var collectionValidator = new NonEmptyCollectionValidatorDecorator(nonNullValidator);
        this.id = id;
        this.orderDate = dateValidator.validate(orderDate, "order date");
        this.orderStatus = nonNullValidator.validate(orderStatus, "order status");
        this.totalPrice = nonNegativeValidator.validate(totalPrice, "total price");
        this.shippingAddress = nonNullValidator.validate(shippingAddress, "shipping address");
        this.billingAddress = nonNullValidator.validate(billingAddress, "billing address");
        this.paymentMethod = nonNullValidator.validate(paymentMethod, "payment method");
        this.paymentStatus = nonNullValidator.validate(paymentStatus, "payment status");
        this.shippingMethod = nonNullValidator.validate(shippingMethod, "shipping method");
        this.orderNotes = orderNotes;
        this.cancellationReason = cancellationReason;
        this.orderCompletionDate = orderCompletionDate;
        this.products = collectionValidator.validate(products, "products");
        this.shopper = shopper;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public LocalDate getOrderDate() {
        return orderDate;
    }

    @Override
    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    @Override
    public Double getTotalPrice() {
        return totalPrice;
    }

    @Override
    public IAddress getShippingAddress() {
        return shippingAddress;
    }

    @Override
    public IAddress getBillingAddress() {
        return billingAddress;
    }

    @Override
    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    @Override
    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    @Override
    public ShippingMethod getShippingMethod() {
        return shippingMethod;
    }

    @Override
    public String getOrderNotes() {
        return orderNotes;
    }

    @Override
    public String getCancellationReason() {
        return cancellationReason;
    }

    @Override
    public LocalDate getOrderCompletionDate() {
        return orderCompletionDate;
    }

    @Override
    public List<IProduct> getProducts() {
        return products;
    }

    @Override
    public IShopper getShopper() {
        return shopper;
    }

}
