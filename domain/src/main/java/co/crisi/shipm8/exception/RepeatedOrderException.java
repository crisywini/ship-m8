package co.crisi.shipm8.exception;

public class RepeatedOrderException extends BusinessException{

    public RepeatedOrderException(String errorMessage) {
        super(errorMessage);
    }

}
