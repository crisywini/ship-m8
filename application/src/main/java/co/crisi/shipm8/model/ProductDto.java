package co.crisi.shipm8.model;

import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;
import lombok.Builder;

@Builder(toBuilder = true)
@Schema(description = "Product Model Info")
public record ProductDto(Long id, Long productId, Integer quantity, Double pricePerUnit, Double totalPrice,
                         List<DiscountDto> discounts, Double tax) {

}
