package co.crisi.shipm8.domain.data;

import co.crisi.shipm8.domain.IAddress;

public record Address(Long id, Shopper shopper, String recipientName, String streetAddress, String city,
                      String stateProvinceRegion, String postalCode, String country, String phoneNumber,
                      AddressType type, Boolean primaryAddress) implements IAddress {

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public Shopper getShopper() {
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
