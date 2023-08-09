package co.crisi.shipm8.domain;

import co.crisi.shipm8.domain.data.Address;
import co.crisi.shipm8.domain.data.Order;
import co.crisi.shipm8.domain.data.Role;
import java.time.LocalDate;
import java.util.List;

public interface IShopper {

    Long getId();

    String getFirstName();

    String getLastName();

    String getEmail();

    String getPassword();

    Integer getPhoneNumber();

    LocalDate getDateOfBirth();

    String getGender();

    LocalDate getRegistrationDate();

    LocalDate getLastLoginDate();

    Role getRole();

    Boolean getActiveStatus();

    String getProfilePicture();

    List<Order> getOrders();

    List<Address> getAddresses();

}
