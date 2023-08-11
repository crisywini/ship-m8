package co.crisi.shipm8.entity;

import co.crisi.shipm8.domain.IAddress;
import co.crisi.shipm8.domain.IOrder;
import co.crisi.shipm8.domain.IShopper;
import co.crisi.shipm8.domain.data.Role;
import java.time.LocalDate;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

@Table(name = "shopper")
@AllArgsConstructor
@NoArgsConstructor
public class ShopperJDBCEntity implements IShopper {

    @Id
    @Column("shopper_id")
    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    private String password;

    private String phoneNumber;

    private LocalDate dateOfBirth;

    private String gender;

    private LocalDate registrationDate;

    private LocalDate lastLoginDate;

    private Role role;

    private Boolean activeStatus;

    private String profilePicture;

    @MappedCollection(idColumn = "shopper_id", keyColumn = "order_id")
    private List<IOrder> orders;

    @MappedCollection(idColumn = "shopper_id", keyColumn = "address_id")
    private List<AddressJDBCEntity> addresses;

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
    public List<IOrder> getOrders() {
        return List.copyOf(orders);
    }

    @Override
    public List<IAddress> getAddresses() {
        return List.copyOf(addresses);
    }

}
