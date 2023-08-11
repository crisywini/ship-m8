package co.crisi.shipm8.model;

import co.crisi.shipm8.domain.data.Applicability;
import co.crisi.shipm8.domain.data.DiscountType;
import java.time.LocalDate;

public record DiscountDto(Long id, String name, Double value, DiscountType type, LocalDate startDate, LocalDate endDate,
                          Applicability applicability, Integer minimumOrderAmount) {

}
