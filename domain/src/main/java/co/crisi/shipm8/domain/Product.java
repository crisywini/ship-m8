package co.crisi.shipm8.domain;

import java.util.List;

public record Product(Long id, Long productId, Integer quantity, Double pricePerUnit, Double totalPrice,
                      List<Discount> discounts, Double tax) {

}
