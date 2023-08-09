package co.crisi.shipm8.exception.business;

public class AddressNotFoundException extends BusinessException{

    public AddressNotFoundException(String errorMessage) {
        super(errorMessage);
    }

}
