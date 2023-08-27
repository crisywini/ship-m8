package co.crisi.shipm8.exception.business;

public class RepeatedOrderException extends RepeatedException {

    public RepeatedOrderException(String errorMessage) {
        super(errorMessage);
    }

}
