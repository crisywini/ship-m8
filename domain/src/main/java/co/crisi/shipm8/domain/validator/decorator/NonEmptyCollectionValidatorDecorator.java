package co.crisi.shipm8.domain.validator.decorator;

import co.crisi.shipm8.domain.validator.IValidator;
import co.crisi.shipm8.exception.validator.EmptyCollectionException;
import co.crisi.shipm8.exception.validator.NotCorrectTypeException;
import java.util.Collection;
import java.util.Optional;

public class NonEmptyCollectionValidatorDecorator extends ValidatorDecorator {

    public NonEmptyCollectionValidatorDecorator(IValidator objectValidator) {
        super(objectValidator);
    }

    @Override
    public <T> T validate(T object, String fieldName) {
        var validate = this.objectValidator.validate(object, fieldName);

        if (!(validate instanceof Collection<?> c)) {
            throw new NotCorrectTypeException("The object is not a collection!");
        }

        return (T) Optional.of(c)
                .filter(v -> !v.isEmpty())
                .orElseThrow(() -> new EmptyCollectionException("The " + fieldName + " is empty!"));
    }

}
