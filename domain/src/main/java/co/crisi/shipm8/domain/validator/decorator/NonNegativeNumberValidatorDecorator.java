package co.crisi.shipm8.domain.validator.decorator;

import co.crisi.shipm8.domain.validator.IValidator;
import co.crisi.shipm8.exception.validator.NegativeNumberException;
import co.crisi.shipm8.exception.validator.NotCorrectTypeException;
import java.util.Optional;

public class NonNegativeNumberValidatorDecorator extends ValidatorDecorator {

    public NonNegativeNumberValidatorDecorator(IValidator objectValidator) {
        super(objectValidator);
    }

    @Override
    public <T> T validate(T object, String fieldName) {
        var validate = this.objectValidator.validate(object, fieldName);
        Object t;
        if(validate instanceof Double e){
            t = e;
        }else if(validate instanceof Integer e){
            t = e;
        }else if(validate instanceof  Long e){
            t = e;
        }else{
            throw new NotCorrectTypeException("Not a number!");
        }
        var errorMessage = "The %s should not be negative!";
        return (T) Optional.of(t)
                .filter(e -> ((Number) e).floatValue() >= 0)
                .orElseThrow(() -> new NegativeNumberException(String.format(errorMessage, fieldName)));
    }

}
