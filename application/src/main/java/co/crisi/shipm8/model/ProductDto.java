package co.crisi.shipm8.model;

import co.crisi.shipm8.domain.IDiscount;
import java.util.List;
import lombok.Builder;

@Builder(toBuilder = true)
public record ProductDto(Long id, Long productId, Integer quantity, Double pricePerUnit, Double totalPrice,
                         List<IDiscount> discounts, Double tax) {

}
