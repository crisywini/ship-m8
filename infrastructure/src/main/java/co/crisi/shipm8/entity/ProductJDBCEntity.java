package co.crisi.shipm8.entity;

import co.crisi.shipm8.domain.IDiscount;
import co.crisi.shipm8.domain.IOrder;
import co.crisi.shipm8.domain.IProduct;
import java.io.Serializable;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

@AllArgsConstructor
@NoArgsConstructor
@Table(name = "product")
public class ProductJDBCEntity implements Serializable, IProduct {


    @Id
    @Column("product_id")
    private Long id;

    @Column("og_product_id")
    private Long productId;

    private Integer quantity;

    private Double pricePerUnit;

    private Double totalPrice;

    @MappedCollection(idColumn = "product_id", keyColumn = "discount_id")
    private List<DiscountJDBCEntity> discounts;

    private Double tax;

    private OrderJDBCEntity order;

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

    public IOrder getOrder() {
        return order;
    }

}
