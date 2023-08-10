package co.crisi.shipm8.entity;

import co.crisi.shipm8.domain.IAddress;
import co.crisi.shipm8.domain.IShopper;
import co.crisi.shipm8.domain.data.AddressType;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@NoArgsConstructor
@AllArgsConstructor
@Table(name = "address")
@Builder
public class AddressJDBCEntity implements Serializable, IAddress {

    @Id
    @Column("address_id")
    private Long id;

    private ShopperJDBCEntity shopper;

    private String recipientName;

    private String streetAddress;

    private String city;

    private String stateProvinceRegion;

    private String postalCode;

    private String country;

    private String phoneNumber;

    private AddressType type;

    private Boolean primaryAddress;

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

}
