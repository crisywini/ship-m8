package co.crisi.shipm8.domain.event;


import java.util.List;

public class OrderProcessed extends Message<List<ProductUpdate>> {

    public OrderProcessed(List<ProductUpdate> value) {
        super(value);
    }

    @Override
    public String getKey() {
        return Messages.ORDER_PROCESSED;
    }

}
