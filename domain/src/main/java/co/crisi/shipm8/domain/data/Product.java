package co.crisi.shipm8.domain.data;

import co.crisi.shipm8.domain.IProduct;
import co.crisi.shipm8.domain.data.Discount;
import java.util.List;

public record Product(Long id, Long productId, Integer quantity, Double pricePerUnit, Double totalPrice,
                      List<Discount> discounts, Double tax) implements IProduct {

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public Long getProductId() {
        return productId;
    }

    @Override
    public Integer getQuantity() {
        return quantity;
    }

    @Override
    public Double getPricePerUnit() {
        return pricePerUnit;
    }

    @Override
    public Double getTotalPrice() {
        return totalPrice;
    }

    @Override
    public List<Discount> getDiscounts() {
        return discounts;
    }

    @Override
    public Double getTax() {
        return tax;
    }

}
