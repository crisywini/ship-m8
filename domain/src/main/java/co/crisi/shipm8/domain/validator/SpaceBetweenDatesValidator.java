package co.crisi.shipm8.domain.validator;

import co.crisi.shipm8.exception.validator.IllegalDateException;
import java.time.LocalDate;
import lombok.experimental.UtilityClass;

@UtilityClass
public class SpaceBetweenDatesValidator {


    public LocalDate validate(LocalDate dateOne, LocalDate dateTwo) {
        if (dateOne.isAfter(dateTwo)) {
            throw new IllegalDateException("The dates are not correct! start date is after end date!");
        }
        if (dateTwo.isEqual(dateOne)) {
            throw new IllegalDateException("The dates are equal!");
        }
        return dateTwo;
    }

}
