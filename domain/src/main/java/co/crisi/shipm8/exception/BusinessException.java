package co.crisi.shipm8.exception;

public class BusinessException extends RuntimeException{

    public BusinessException(String errorMessage){
        super(errorMessage);
    }

}
