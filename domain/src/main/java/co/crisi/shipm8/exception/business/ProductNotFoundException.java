package co.crisi.shipm8.exception.business;

public class ProductNotFoundException extends NotFoundException {

    public ProductNotFoundException(String errorMessage) {
        super(errorMessage);
    }

}
