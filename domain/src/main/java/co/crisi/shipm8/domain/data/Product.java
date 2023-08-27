package co.crisi.shipm8.domain.data;

import co.crisi.shipm8.domain.IDiscount;
import co.crisi.shipm8.domain.IProduct;
import co.crisi.shipm8.domain.validator.decorator.NonNegativeNumberValidatorDecorator;
import co.crisi.shipm8.domain.validator.decorator.NonNullValidatorDecorator;
import co.crisi.shipm8.domain.validator.decorator.Validator;
import java.util.List;

public record Product(Long id, Long productId, Integer quantity, Double pricePerUnit, Double totalPrice,
                      List<IDiscount> discounts, Double tax) implements IProduct {

    public Product(Long id, Long productId, Integer quantity, Double pricePerUnit, Double totalPrice,
            List<IDiscount> discounts, Double tax) {
        var validator = new Validator();
        var nonNullValidator = new NonNullValidatorDecorator(validator);
        var nonNegativeNumberValidator = new NonNegativeNumberValidatorDecorator(nonNullValidator);
        this.id = id;
        this.productId = nonNullValidator.validate(productId, "product id");
        this.quantity = nonNegativeNumberValidator.validate(quantity, "quantity");
        this.pricePerUnit = nonNegativeNumberValidator.validate(pricePerUnit, "price per unit");
        this.totalPrice = nonNegativeNumberValidator.validate(totalPrice, "total price");
        this.discounts = discounts;
        this.tax = nonNegativeNumberValidator.validate(tax, "tax");
    }

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
    public List<IDiscount> getDiscounts() {
        return discounts;
    }

    @Override
    public Double getTax() {
        return tax;
    }

}
