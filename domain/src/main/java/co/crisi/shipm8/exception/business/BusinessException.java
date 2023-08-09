package co.crisi.shipm8.exception.business;

public class BusinessException extends RuntimeException{

    public BusinessException(String errorMessage){
        super(errorMessage);
    }

}
