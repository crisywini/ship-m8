package co.crisi.shipm8.domain.message;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.ToString;

@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderFailed extends Message<FailedOrderDto> {

    private final FailedOrderDto failedOrder;

    public OrderFailed(
            @JsonProperty("failedOrder")
                    FailedOrderDto failedOrder) {
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
