package co.crisi.shipm8.exception.business;

public class NotFoundException extends BusinessException{

    public NotFoundException(String errorMessage) {
        super(errorMessage);
    }

}
