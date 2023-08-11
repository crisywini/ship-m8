package co.crisi.shipm8.model;

import co.crisi.shipm8.domain.data.OrderStatus;
import co.crisi.shipm8.domain.data.PaymentMethod;
import co.crisi.shipm8.domain.data.PaymentStatus;
import co.crisi.shipm8.domain.data.ShippingMethod;
import java.time.LocalDate;
import java.util.List;
import lombok.Builder;

@Builder(toBuilder = true)
public record OrderDto(Long id, LocalDate orderDate, OrderStatus orderStatus, Double totalPrice,
                       AddressDto shippingAddress,
                       AddressDto billingAddress, PaymentMethod paymentMethod, PaymentStatus paymentStatus,
                       ShippingMethod shippingMethod, String orderNotes, String cancellationReason,
                       LocalDate orderCompletionDate, List<ProductDto> products) {

}
