package co.crisi.shipm8.domain;

import co.crisi.shipm8.domain.data.OrderStatus;
import co.crisi.shipm8.domain.data.PaymentMethod;
import co.crisi.shipm8.domain.data.PaymentStatus;
import co.crisi.shipm8.domain.data.ShippingMethod;
import java.time.LocalDate;
import java.util.List;

public interface IOrder {

    Long getId();

    LocalDate getOrderDate();

    OrderStatus getOrderStatus();

    Double getTotalPrice();

    IAddress getShippingAddress();

    IAddress getBillingAddress();

    PaymentMethod getPaymentMethod();

    PaymentStatus getPaymentStatus();

    ShippingMethod getShippingMethod();

    String getOrderNotes();

    String getCancellationReason();

    LocalDate getOrderCompletionDate();

    List<? extends IProduct> getProducts();

    IShopper getShopper();

}
