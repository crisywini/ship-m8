package co.crisi.shipm8.domain.validator;

public interface IValidator {

    <T extends Object> T validate(T object, String fieldName);

}
