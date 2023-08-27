package co.crisi.shipm8.model;

import java.util.List;
import lombok.Builder;

@Builder(toBuilder = true)
public record ProductDto(Long id, Long productId, Integer quantity, Double pricePerUnit, Double totalPrice,
                         List<DiscountDto> discounts, Double tax) {

}
