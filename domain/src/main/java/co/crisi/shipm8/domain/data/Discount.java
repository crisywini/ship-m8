package co.crisi.shipm8.domain.data;

import co.crisi.shipm8.domain.IDiscount;
import java.time.LocalDate;

public record Discount(Long id, String name, Double value, DiscountType type, LocalDate startDate, LocalDate endDate,
                       Applicability applicability, Integer minimumOrderAmount) implements IDiscount {

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

}
