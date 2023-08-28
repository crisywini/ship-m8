package co.crisi.shipm8.entity.jpa;

import co.crisi.shipm8.domain.IDiscount;
import co.crisi.shipm8.domain.data.Applicability;
import co.crisi.shipm8.domain.data.DiscountType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "discount")
@NoArgsConstructor
@AllArgsConstructor
public class DiscountJPAEntity implements IDiscount, Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Double value;

    @Enumerated(EnumType.STRING)
    private DiscountType type;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @Enumerated(EnumType.STRING)
    private Applicability applicability;

    @Column(name = "minimum_order_amount")
    private Integer minimumOrderAmount;

    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "product_id")
    private ProductJPAEntity product;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Double getValue() {
        return value;
    }

    @Override
    public DiscountType getType() {
        return type;
    }

    @Override
    public LocalDate getStartDate() {
        return startDate;
    }

    @Override
    public LocalDate getEndDate() {
        return endDate;
    }

    @Override
    public Applicability getApplicability() {
        return applicability;
    }

    @Override
    public Integer getMinimumOrderAmount() {
        return minimumOrderAmount;
    }

    public ProductJPAEntity getProduct() {
        return product;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        DiscountJPAEntity that = (DiscountJPAEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
