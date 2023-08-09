package co.crisi.shipm8.domain;

import java.time.LocalDate;
import java.util.List;

public record Order(Long id, LocalDate orderDate, OrderStatus orderStatus, Double totalPrice, Address shippingAddress,
                    Address billingAddress, PaymentMethod paymentMethod, PaymentStatus paymentStatus,
                    ShippingMethod shippingMethod, String orderNotes, String cancellationReason,
                    LocalDate orderCompletionDate, List<Product> products, Shopper shopper) {

}
