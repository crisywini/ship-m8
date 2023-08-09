package co.crisi.shipm8.domain.data;

import co.crisi.shipm8.domain.IShopper;
import co.crisi.shipm8.domain.validator.SpaceBetweenDatesValidator;
import co.crisi.shipm8.domain.validator.decorator.DateValidatorDecorator;
import co.crisi.shipm8.domain.validator.decorator.NonEmptyValidatorDecorator;
import co.crisi.shipm8.domain.validator.decorator.NonNullValidatorDecorator;
import co.crisi.shipm8.domain.validator.decorator.Validator;
import java.time.LocalDate;
import java.util.List;

public record Shopper(Long id, String firstName, String lastName, String email,
                      String password, String phoneNumber, LocalDate dateOfBirth,
                      String gender, LocalDate registrationDate,
                      LocalDate lastLoginDate, Role role, Boolean activeStatus,
                      String profilePicture, List<Order> orders, List<Address> addresses) implements IShopper {

    public Shopper(Long id, String firstName, String lastName, String email, String password, String phoneNumber,
            LocalDate dateOfBirth, String gender, LocalDate registrationDate, LocalDate lastLoginDate, Role role,
            Boolean activeStatus, String profilePicture, List<Order> orders, List<Address> addresses) {
        var validator = new Validator();
        var nonNullValidator = new NonNullValidatorDecorator(validator);
        var nonEmptyStringValidator = new NonEmptyValidatorDecorator(nonNullValidator);
        var dateValidator = new DateValidatorDecorator(nonNullValidator);
        this.id = id;
        this.firstName = nonEmptyStringValidator.validate(firstName, "first name");
        this.lastName = nonEmptyStringValidator.validate(lastName, "last name");
        this.email = nonEmptyStringValidator.validate(email, "email");
        this.password = nonEmptyStringValidator.validate(password, "password");
        this.phoneNumber = nonEmptyStringValidator.validate(phoneNumber, "phone number");
        this.dateOfBirth = dateValidator.validate(dateOfBirth, "date of birth");
        this.gender = nonNullValidator.validate(gender, "gender");
        this.registrationDate = dateValidator.validate(registrationDate, "registration date");
        this.lastLoginDate = dateValidator.validate(lastLoginDate, "last login date");
        this.role = nonNullValidator.validate(role, "role");
        this.activeStatus = activeStatus;
        this.profilePicture = profilePicture;
        this.orders = orders;
        this.addresses = addresses;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public String getFirstName() {
        return firstName;
    }

    @Override
    public String getLastName() {
        return lastName;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    @Override
    public String getGender() {
        return gender;
    }

    @Override
    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    @Override
    public LocalDate getLastLoginDate() {
        return lastLoginDate;
    }

    @Override
    public Role getRole() {
        return role;
    }

    @Override
    public Boolean getActiveStatus() {
        return activeStatus;
    }

    @Override
    public String getProfilePicture() {
        return profilePicture;
    }

    @Override
    public List<Order> getOrders() {
        return orders;
    }

    @Override
    public List<Address> getAddresses() {
        return addresses;
    }

}
