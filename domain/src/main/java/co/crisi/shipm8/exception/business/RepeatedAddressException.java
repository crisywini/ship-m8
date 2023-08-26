package co.crisi.shipm8.exception.business;

public class RepeatedAddressException extends RepeatedException {

    public RepeatedAddressException(String errorMessage) {
        super(errorMessage);
    }

}
