package co.crisi.shipm8.domain;

import java.time.LocalDate;

public record Discount(Long id, String name, Double value, DiscountType type, LocalDate startDate, LocalDate endDate,
                       Applicability applicability, Integer minimumOrderAmount) {

}
