package co.crisi.shipm8.entity.jpa;

import co.crisi.shipm8.domain.IAddress;
import co.crisi.shipm8.domain.IOrder;
import co.crisi.shipm8.domain.IProduct;
import co.crisi.shipm8.domain.IShopper;
import co.crisi.shipm8.domain.data.OrderStatus;
import co.crisi.shipm8.domain.data.PaymentMethod;
import co.crisi.shipm8.domain.data.PaymentStatus;
import co.crisi.shipm8.domain.data.ShippingMethod;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "order_table")
@AllArgsConstructor
@NoArgsConstructor
@Setter
public class OrderJPAEntity implements IOrder, Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "order_date")
    private LocalDate orderDate;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    @Column(name = "total_price")
    private Double totalPrice;

    @OneToOne
    @JoinColumn(name = "shipping_address_id", referencedColumnName = "id")
    private AddressJPAEntity shippingAddress;

    @OneToOne
    @JoinColumn(name = "billing_address_id", referencedColumnName = "id")
    private AddressJPAEntity billingAddress;

    @Column(name = "payment_method")
    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;

    @Column(name = "payment_status")
    @Enumerated(EnumType.STRING)
    private PaymentStatus paymentStatus;

    @Column(name = "shipping_method")
    @Enumerated(EnumType.STRING)
    private ShippingMethod shippingMethod;

    @Column(name = "order_notes")
    private String orderNotes;

    @Column(name = "cancellation_reason")
    private String cancellationReason;

    @Column(name = "order_completion_date")
    private LocalDate orderCompletionDate;

    @OneToMany
    private List<ProductJPAEntity> products;

    @ManyToOne
    @JoinColumn(name = "shopper_id", referencedColumnName = "shopper_id")
    private ShopperJPAEntity shopper;

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
    public List<ProductJPAEntity> getProducts() {
        return products;
    }

    @Override
    public IShopper getShopper() {
        return shopper;
    }

}
