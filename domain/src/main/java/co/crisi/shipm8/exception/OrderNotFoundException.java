package co.crisi.shipm8.exception;

public class OrderNotFoundException extends BusinessException {

    public OrderNotFoundException(String errorMessage) {
        super(errorMessage);
    }

}
