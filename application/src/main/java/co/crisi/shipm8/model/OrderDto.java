package co.crisi.shipm8.model;

import co.crisi.shipm8.domain.data.OrderStatus;
import co.crisi.shipm8.domain.data.PaymentMethod;
import co.crisi.shipm8.domain.data.PaymentStatus;
import co.crisi.shipm8.domain.data.ShippingMethod;
import io.swagger.v3.oas.annotations.media.Schema;
import java.time.LocalDate;
import java.util.List;
import lombok.Builder;

@Builder(toBuilder = true)
@Schema(description = "Order Model Info")
public record OrderDto(Long id, LocalDate orderDate, OrderStatus orderStatus, Double totalPrice,
                       AddressDto shippingAddress,
                       AddressDto billingAddress, PaymentMethod paymentMethod, PaymentStatus paymentStatus,
                       ShippingMethod shippingMethod, String orderNotes, String cancellationReason,
                       LocalDate orderCompletionDate, List<ProductDto> products) {

}
