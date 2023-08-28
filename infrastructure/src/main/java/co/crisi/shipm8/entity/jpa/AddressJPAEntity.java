package co.crisi.shipm8.entity.jpa;

import co.crisi.shipm8.domain.IAddress;
import co.crisi.shipm8.domain.IShopper;
import co.crisi.shipm8.domain.data.AddressType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.Objects;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "address")
@NoArgsConstructor
@AllArgsConstructor
public class AddressJPAEntity implements IAddress, Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "shopper_id")
    private ShopperJPAEntity shopper;

    @Column(name = "recipient_name")
    private String recipientName;

    @Column(name = "street_address")
    private String streetAddress;

    private String city;

    @Column(name = "state_province_region")
    private String stateProvinceRegion;

    @Column(name = "postal_code")
    private String postalCode;

    private String country;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Enumerated(EnumType.STRING)
    private AddressType type;

    @Column(name = "primary_address")
    private boolean primaryAddress;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public IShopper getShopper() {
        return shopper;
    }

    @Override
    public String getRecipientName() {
        return recipientName;
    }

    @Override
    public String getStreetAddress() {
        return streetAddress;
    }

    @Override
    public String getCity() {
        return city;
    }

    @Override
    public String getStateProvinceRegion() {
        return stateProvinceRegion;
    }

    @Override
    public String getPostalCode() {
        return postalCode;
    }

    @Override
    public String getCountry() {
        return country;
    }

    @Override
    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public AddressType getType() {
        return type;
    }

    @Override
    public Boolean isPrimaryAddress() {
        return primaryAddress;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AddressJPAEntity that = (AddressJPAEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
