package co.crisi.shipm8.domain.data;

import co.crisi.shipm8.domain.IShopper;
import java.time.LocalDate;
import java.util.List;

public record Shopper(Long id, String firstName, String lastName, String email,
                      String password, Integer phoneNumber, LocalDate dateOfBirth,
                      String gender, LocalDate registrationDate,
                      LocalDate lastLoginDate, Role role, Boolean activeStatus,
                      String profilePicture, List<Order> orders, List<Address> addresses) implements IShopper {

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
    public Integer getPhoneNumber() {
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
