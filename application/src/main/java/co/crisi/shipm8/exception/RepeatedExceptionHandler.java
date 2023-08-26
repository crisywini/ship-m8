package co.crisi.shipm8.exception;

import co.crisi.shipm8.exception.business.RepeatedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class RepeatedExceptionHandler {

    @ExceptionHandler(RepeatedException.class)
    public @ResponseBody
    ResponseEntity<String> handleRepeatedException(RepeatedException exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
    }

}
