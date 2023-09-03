package co.crisi.shipm8.domain.event;

public class OrderFailed extends Message<FailedOrderDto>{

    private final FailedOrderDto failedOrder;

    public OrderFailed(FailedOrderDto failedOrder) {
        super(failedOrder);
        this.failedOrder = failedOrder;
    }

    @Override
    public String getKey() {
        return Messages.ORDER_FAILED;
    }

    public FailedOrderDto getFailedOrder() {
        return failedOrder;
    }

}
