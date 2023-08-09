package co.crisi.shipm8.domain;

import co.crisi.shipm8.domain.data.AddressType;
import co.crisi.shipm8.domain.data.Shopper;

public interface IAddress {

    Long getId();

    Shopper getShopper();

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
