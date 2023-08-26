package co.crisi.shipm8.entity;


import co.crisi.shipm8.domain.IDiscount;
import co.crisi.shipm8.domain.data.Applicability;
import co.crisi.shipm8.domain.data.DiscountType;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@NoArgsConstructor
@AllArgsConstructor
@Table(name = "discount")
@Builder
public class DiscountJDBCEntity implements Serializable, IDiscount{

    @Id
    @Column("discount_id")
    private Long id;

    private String name;

    private Double value;

    private DiscountType type;

    @Column("start_date")
    private LocalDate startDate;

    @Column("end_date")
    private LocalDate endDate;

    private Applicability applicability;

    @Column("minimum_order_amount")
    private Integer minimumOrderAmount;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        DiscountJDBCEntity that = (DiscountJDBCEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
