package co.crisi.shipm8.domain.data;

import co.crisi.shipm8.domain.IDiscount;
import co.crisi.shipm8.domain.validator.SpaceBetweenDatesValidator;
import co.crisi.shipm8.domain.validator.decorator.DateValidatorDecorator;
import co.crisi.shipm8.domain.validator.decorator.NonEmptyValidatorDecorator;
import co.crisi.shipm8.domain.validator.decorator.NonNegativeNumberValidatorDecorator;
import co.crisi.shipm8.domain.validator.decorator.NonNullValidatorDecorator;
import co.crisi.shipm8.domain.validator.decorator.Validator;
import java.time.LocalDate;

public record Discount(Long id, String name, Double value, DiscountType type, LocalDate startDate, LocalDate endDate,
                       Applicability applicability, Integer minimumOrderAmount) implements IDiscount {

    public Discount(Long id, String name, Double value, DiscountType type, LocalDate startDate, LocalDate endDate,
            Applicability applicability, Integer minimumOrderAmount) {
        var validator = new Validator();
        var nonNullValidator = new NonNullValidatorDecorator(validator);
        var nonEmptyValidator = new NonEmptyValidatorDecorator(nonNullValidator);
        var dateValidator = new DateValidatorDecorator(nonNullValidator);
        var nonNegativeValidator = new NonNegativeNumberValidatorDecorator(nonNullValidator);
        this.id = id;
        this.name = nonEmptyValidator.validate(name, "name");
        this.value = nonNegativeValidator.validate(value, "value");
        this.type = nonNullValidator.validate(type, "type");
        this.startDate = dateValidator.validate(startDate, "start date");
        this.endDate = SpaceBetweenDatesValidator.validate(startDate, endDate);
        this.applicability = nonNullValidator.validate(applicability, "applicability");
        this.minimumOrderAmount = nonNegativeValidator.validate(minimumOrderAmount, "minimum order amount");
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Double getValue() {
        return value;
    }

    @Override
    public DiscountType getType() {
        return type;
    }

    @Override
    public LocalDate getStartDate() {
        return startDate;
    }

    @Override
    public LocalDate getEndDate() {
        return endDate;
    }

    @Override
    public Applicability getApplicability() {
        return applicability;
    }

    @Override
    public Integer getMinimumOrderAmount() {
        return minimumOrderAmount;
    }

}
