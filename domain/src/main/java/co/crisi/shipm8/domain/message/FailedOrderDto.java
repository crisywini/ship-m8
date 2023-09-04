package co.crisi.shipm8.domain.message;

import com.fasterxml.jackson.annotation.JsonProperty;

public record FailedOrderDto(@JsonProperty("orderId") Long orderId, @JsonProperty("error") String errorMessage) {

}
