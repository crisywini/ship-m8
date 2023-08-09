package co.crisi.shipm8.exception.business;

public class RepeatedOrderException extends BusinessException{

    public RepeatedOrderException(String errorMessage) {
        super(errorMessage);
    }

}
