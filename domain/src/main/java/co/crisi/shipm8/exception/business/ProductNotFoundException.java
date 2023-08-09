package co.crisi.shipm8.exception.business;

public class ProductNotFoundException extends BusinessException{

    public ProductNotFoundException(String errorMessage) {
        super(errorMessage);
    }

}
