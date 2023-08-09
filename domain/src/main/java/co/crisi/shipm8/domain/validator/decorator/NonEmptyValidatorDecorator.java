package co.crisi.shipm8.domain.validator.decorator;

import co.crisi.shipm8.domain.validator.IValidator;
import co.crisi.shipm8.exception.validator.EmptyStringException;
import co.crisi.shipm8.exception.validator.NotCorrectTypeException;
import java.util.Optional;

public class NonEmptyValidatorDecorator extends ValidatorDecorator {

    public NonEmptyValidatorDecorator(IValidator objectValidator) {
        super(objectValidator);
    }


    @Override
    public <T> T validate(T object, String fieldName) {
        var validate = this.objectValidator.validate(object, fieldName);
        String t;
        if (validate instanceof String s) {
            t = s;
        } else {
            throw new NotCorrectTypeException("Not a string!");
        }
        var errorMessage = "The %s should not be empty!";
        return (T) Optional.of(t)
                .filter(v -> !v.isEmpty())
                .orElseThrow(() -> new EmptyStringException(String.format(errorMessage, fieldName)));
    }

}
