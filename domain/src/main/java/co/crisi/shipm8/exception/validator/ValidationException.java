package co.crisi.shipm8.exception.validator;

public class ValidationException extends RuntimeException {

    public ValidationException(String errorMessage) {
        super(errorMessage);
    }

}
