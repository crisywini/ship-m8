package co.crisi.shipm8.adapter.kafka;

import co.crisi.shipm8.domain.IProduct;
import co.crisi.shipm8.domain.data.Order;
import co.crisi.shipm8.domain.data.OrderStatus;
import co.crisi.shipm8.domain.data.PaymentStatus;
import co.crisi.shipm8.domain.message.OrderFailed;
import co.crisi.shipm8.domain.message.Topics;
import co.crisi.shipm8.port.api.IOrderServicePort;
import co.crisi.shipm8.port.spi.message.IReceiveMessagePort;
import java.time.LocalDate;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Component
@RequiredArgsConstructor
public class OrderFailedKafkaConsumerAdapter implements IReceiveMessagePort<OrderFailed> {

    private final IOrderServicePort servicePort;

    @Transactional
    @KafkaListener(id = "id", topics = Topics.EXCEPTION)
    @Override
    public void listen(OrderFailed message) {
        log.info("Processing order failed message! {} ", message.getFailedOrder());

        var order = servicePort.getById(message.getFailedOrder().orderId());
        var newOrderInfo = Order.builder()
                .id(order.getId())
                .orderDate(order.getOrderDate())
                .orderStatus(OrderStatus.FAILED)
                .totalPrice(order.getTotalPrice())
                .shippingAddress(order.getShippingAddress())
                .billingAddress(order.getBillingAddress())
                .paymentMethod(order.getPaymentMethod())
                .paymentStatus(PaymentStatus.FAILED)
                .shippingMethod(order.getShippingMethod())
                .orderNotes(order.getOrderNotes())
                .cancellationReason(message.getFailedOrder().errorMessage())
                .orderCompletionDate(LocalDate.now())
                .products((List<IProduct>) order.getProducts())
                .shopper(order.getShopper())
                .build();
        var orderUpdated = servicePort.update(message.getFailedOrder().orderId(), newOrderInfo);
        log.debug("Order failed with id {}", orderUpdated.getId());
    }

}
