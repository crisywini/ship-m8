package co.crisi.shipm8.domain.validator.decorator;

import co.crisi.shipm8.domain.validator.IValidator;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public abstract class ValidatorDecorator implements IValidator {

    protected IValidator objectValidator;

    @Override
    public <T> T validate(T object, String fieldName) {
        return this.objectValidator.validate(object, fieldName);
    }

}
