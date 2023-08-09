package co.crisi.shipm8.domain;

import co.crisi.shipm8.domain.data.Address;
import co.crisi.shipm8.domain.data.OrderStatus;
import co.crisi.shipm8.domain.data.PaymentMethod;
import co.crisi.shipm8.domain.data.PaymentStatus;
import co.crisi.shipm8.domain.data.Product;
import co.crisi.shipm8.domain.data.ShippingMethod;
import co.crisi.shipm8.domain.data.Shopper;
import java.time.LocalDate;
import java.util.List;

public interface IOrder {

    Long getId();

    LocalDate getOrderDate();

    OrderStatus getOrderStatus();

    Double getTotalPrice();

    Address getShippingAddress();

    Address getBillingAddress();

    PaymentMethod getPaymentMethod();

    PaymentStatus getPaymentStatus();

    ShippingMethod getShippingMethod();

    String getOrderNotes();

    String getCancellationReason();

    LocalDate getOrderCompletionDate();

    List<Product> getProducts();

    Shopper getShopper();

}
