package co.crisi.shipm8.domain.event;


import java.util.List;

public class OrderProcessed extends Message<OrderDto> {

    private final OrderDto order;

    public OrderProcessed(OrderDto order) {
        super(order);
        this.order = order;
    }

    @Override
    public String getKey() {
        return Messages.ORDER_PROCESSED;
    }

    public OrderDto getOrder() {
        return order;
    }

}
