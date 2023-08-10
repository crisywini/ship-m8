package co.crisi.shipm8.domain;

import co.crisi.shipm8.domain.data.AddressType;

public interface IAddress {

    Long getId();

    IShopper getShopper();

    String getRecipientName();

    String getStreetAddress();

    String getCity();

    String getStateProvinceRegion();

    String getPostalCode();

    String getCountry();

    String getPhoneNumber();

    AddressType getType();

    Boolean isPrimaryAddress();

}
