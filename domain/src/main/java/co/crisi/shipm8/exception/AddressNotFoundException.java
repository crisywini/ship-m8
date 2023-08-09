package co.crisi.shipm8.exception;

public class AddressNotFoundException extends BusinessException{

    public AddressNotFoundException(String errorMessage) {
        super(errorMessage);
    }

}
