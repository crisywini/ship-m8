package co.crisi.shipm8.domain.validator.decorator;

import co.crisi.shipm8.domain.validator.IValidator;
import co.crisi.shipm8.exception.validator.IllegalDateException;
import co.crisi.shipm8.exception.validator.NotCorrectTypeException;
import java.time.LocalDate;
import java.util.Optional;

public class DateValidatorDecorator extends ValidatorDecorator {

    public DateValidatorDecorator(IValidator objectValidator) {
        super(objectValidator);
    }

    @Override
    public <T> T validate(T object, String fieldName) {
        var validate = this.objectValidator.validate(object, fieldName);
        LocalDate asDate;
        if (validate instanceof LocalDate date) {
            asDate = date;
        } else {
            throw new NotCorrectTypeException("Not a date!");
        }
        var errorMessage = "The %s should be a valid date!";
        return (T) Optional.of(asDate)
                .filter(d -> d.isAfter(LocalDate.MIN))
                .orElseThrow(() -> new IllegalDateException(String.format(errorMessage, fieldName)));
    }

}
