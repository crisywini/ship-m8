package co.crisi.shipm8.exception;

public class ProductNotFoundException extends BusinessException{

    public ProductNotFoundException(String errorMessage) {
        super(errorMessage);
    }

}
