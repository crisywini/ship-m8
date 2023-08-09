package co.crisi.shipm8.domain.validator.decorator;

import co.crisi.shipm8.domain.validator.IValidator;

public class Validator implements IValidator {

    @Override
    public <T> T validate(T object, String fieldName) {
        return object;
    }

}
