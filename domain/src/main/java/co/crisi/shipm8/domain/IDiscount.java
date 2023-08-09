package co.crisi.shipm8.domain;

import co.crisi.shipm8.domain.data.Applicability;
import co.crisi.shipm8.domain.data.DiscountType;
import java.time.LocalDate;

public interface IDiscount {

    Long getId();

    String getName();

    Double getValue();

    DiscountType getType();

    LocalDate getStartDate();

    LocalDate getEndDate();

    Applicability getApplicability();

    Integer getMinimumOrderAmount();

}
