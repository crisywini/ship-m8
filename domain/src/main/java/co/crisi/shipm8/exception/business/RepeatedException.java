package co.crisi.shipm8.exception.business;

public class RepeatedException extends BusinessException{

    public RepeatedException(String errorMessage) {
        super(errorMessage);
    }

}
