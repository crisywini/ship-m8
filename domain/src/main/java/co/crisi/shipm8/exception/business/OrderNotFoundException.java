package co.crisi.shipm8.exception.business;

public class OrderNotFoundException extends NotFoundException {

    public OrderNotFoundException(String errorMessage) {
        super(errorMessage);
    }

}
