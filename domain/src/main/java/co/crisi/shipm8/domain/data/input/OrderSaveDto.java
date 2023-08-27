package co.crisi.shipm8.domain.data.input;

import co.crisi.shipm8.domain.data.OrderStatus;
import co.crisi.shipm8.domain.data.PaymentMethod;
import co.crisi.shipm8.domain.data.PaymentStatus;
import co.crisi.shipm8.domain.data.ShippingMethod;
import java.time.LocalDate;
import java.util.List;
import lombok.Builder;

@Builder
public record OrderSaveDto(LocalDate orderDate, OrderStatus orderStatus, Double totalPrice,
                           Long shippingAddressId,
                           Long billingAddressId, PaymentMethod paymentMethod, PaymentStatus paymentStatus,
                           ShippingMethod shippingMethod, String orderNotes, String cancellationReason,
                           LocalDate orderCompletionDate, List<Long> productIds, Long shopperId) {
}
