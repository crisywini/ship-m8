package co.crisi.shipm8.model;

import co.crisi.shipm8.domain.data.Applicability;
import co.crisi.shipm8.domain.data.DiscountType;
import io.swagger.v3.oas.annotations.media.Schema;
import java.time.LocalDate;
import lombok.Builder;

@Builder(toBuilder = true)
@Schema(description = "Discount Model Info")
public record DiscountDto(Long id, String name, Double value, DiscountType type, LocalDate startDate, LocalDate endDate,
                          Applicability applicability, Integer minimumOrderAmount) {

}
