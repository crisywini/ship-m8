package co.crisi.shipm8.entity.jpa;

import co.crisi.shipm8.domain.IAddress;
import co.crisi.shipm8.domain.IOrder;
import co.crisi.shipm8.domain.IShopper;
import co.crisi.shipm8.domain.data.Role;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "shopper")
@NoArgsConstructor
@AllArgsConstructor
public class ShopperJPAEntity implements IShopper, Serializable {

    @Id
    @Column(name = "shopper_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    private String email;

    private String password;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    private String gender;

    @Column(name = "registration_date")
    private LocalDate registrationDate;

    @Column(name = "last_login_date")
    private LocalDate lastLoginDate;

    @Enumerated(EnumType.STRING)
    private Role role;

    @Column(name = "active_status")
    private Boolean activeStatus;

    @Column(name = "profile_picture")
    private String profilePicture;

    @OneToMany(mappedBy = "shopper")
    private List<OrderJPAEntity> orders;

    @OneToMany(mappedBy = "shopper")
    private List<AddressJPAEntity> addresses;

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
