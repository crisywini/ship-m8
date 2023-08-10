package co.crisi.shipm8.entity;

import co.crisi.shipm8.domain.IAddress;
import co.crisi.shipm8.domain.IOrder;
import co.crisi.shipm8.domain.IProduct;
import co.crisi.shipm8.domain.IShopper;
import co.crisi.shipm8.domain.data.OrderStatus;
import co.crisi.shipm8.domain.data.PaymentMethod;
import co.crisi.shipm8.domain.data.PaymentStatus;
import co.crisi.shipm8.domain.data.ShippingMethod;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

@Table(name = "order")
@AllArgsConstructor
@NoArgsConstructor
public class OrderJDBCEntity implements Serializable, IOrder {

    @Id
    @Column("order_id")
    private Long id;

    private LocalDate orderDate;

    private OrderStatus status;

    private Double totalPrice;

    private AddressJDBCEntity shippingAddress;

    private AddressJDBCEntity billingAddress;

    private PaymentMethod paymentMethod;

    private PaymentStatus paymentStatus;

    private ShippingMethod shippingMethod;

    private String orderNotes;

    private String cancellationReason;

    private LocalDate orderCompletionDate;

    @MappedCollection(idColumn = "product_id", keyColumn = "order_id")
    private List<ProductJDBCEntity> products;

    private ShopperJDBCEntity shopper;


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
        return status;
    }

    @Override
    public Double getTotalPrice() {
        return totalPrice;
    }

    @Override
    public IAddress getShippingAddress() {
        return shippingAddress;
    }

    @Override
    public IAddress getBillingAddress() {
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
    public List<IProduct> getProducts() {
        return List.copyOf(products);
    }

    @Override
    public IShopper getShopper() {
        return shopper;
    }

}
