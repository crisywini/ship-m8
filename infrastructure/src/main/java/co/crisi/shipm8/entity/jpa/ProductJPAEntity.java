package co.crisi.shipm8.entity.jpa;

import co.crisi.shipm8.domain.IDiscount;
import co.crisi.shipm8.domain.IProduct;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "product")
public class ProductJPAEntity implements IProduct, Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "og_product_id")
    private Long productId;

    private Integer quantity;

    @Column(name = "price_per_unit")
    private Double pricePerUnit;

    @Column(name = "total_price")
    private Double totalPrice;

    @OneToMany(mappedBy = "product")
    private List<DiscountJPAEntity> discounts;

    private Double tax;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public Long getProductId() {
        return productId;
    }

    @Override
    public Integer getQuantity() {
        return quantity;
    }

    @Override
    public Double getPricePerUnit() {
        return pricePerUnit;
    }

    @Override
    public Double getTotalPrice() {
        return totalPrice;
    }

    @Override
    public List<IDiscount> getDiscounts() {
        return List.copyOf(discounts);
    }

    @Override
    public Double getTax() {
        return tax;
    }

}
