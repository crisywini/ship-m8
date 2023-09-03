package co.crisi.shipm8.domain.event;

public record FailedOrderDto(Long orderId, String errorMessage) {

}
