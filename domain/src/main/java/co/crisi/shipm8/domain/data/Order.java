package co.crisi.shipm8.domain.data;

import co.crisi.shipm8.domain.IOrder;
import java.time.LocalDate;
import java.util.List;

public record Order(Long id, LocalDate orderDate, OrderStatus orderStatus, Double totalPrice, Address shippingAddress,
                    Address billingAddress, PaymentMethod paymentMethod, PaymentStatus paymentStatus,
                    ShippingMethod shippingMethod, String orderNotes, String cancellationReason,
                    LocalDate orderCompletionDate, List<Product> products, Shopper shopper) implements IOrder {

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public LocalDate getOrderDate() {
        return orderDate;
    }

    @Override
    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    @Override
    public Double getTotalPrice() {
        return totalPrice;
    }

    @Override
    public Address getShippingAddress() {
        return shippingAddress;
    }

    @Override
    public Address getBillingAddress() {
        return billingAddress;
    }

    @Override
    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    @Override
    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    @Override
    public ShippingMethod getShippingMethod() {
        return shippingMethod;
    }

    @Override
    public String getOrderNotes() {
        return orderNotes;
    }

    @Override
    public String getCancellationReason() {
        return cancellationReason;
    }

    @Override
    public LocalDate getOrderCompletionDate() {
        return orderCompletionDate;
    }

    @Override
    public List<Product> getProducts() {
        return products;
    }

    @Override
    public Shopper getShopper() {
        return shopper;
    }

}
