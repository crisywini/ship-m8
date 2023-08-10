package co.crisi.shipm8.domain.data;

import co.crisi.shipm8.domain.IAddress;
import co.crisi.shipm8.domain.IShopper;
import co.crisi.shipm8.domain.validator.decorator.NonNullValidatorDecorator;
import co.crisi.shipm8.domain.validator.decorator.NonEmptyValidatorDecorator;
import co.crisi.shipm8.domain.validator.decorator.Validator;

public record Address(Long id, IShopper shopper, String recipientName, String streetAddress, String city,
                      String stateProvinceRegion, String postalCode, String country, String phoneNumber,
                      AddressType type, Boolean primaryAddress) implements IAddress {

    public Address(Long id, IShopper shopper, String recipientName, String streetAddress, String city,
            String stateProvinceRegion, String postalCode, String country, String phoneNumber, AddressType type,
            Boolean primaryAddress) {

        var validator = new Validator();
        var nonNullValidator = new NonNullValidatorDecorator(validator);
        var nonEmptyValidator = new NonEmptyValidatorDecorator(nonNullValidator);
        this.id = id;
        this.shopper = nonNullValidator.validate(shopper, "shopper");
        this.recipientName = nonEmptyValidator.validate(recipientName, "recipient name");
        this.streetAddress = nonEmptyValidator.validate(streetAddress, "street address");
        this.city = nonEmptyValidator.validate(city, "city");
        this.stateProvinceRegion = nonEmptyValidator.validate(stateProvinceRegion, "state/province/region");
        this.postalCode = nonEmptyValidator.validate(postalCode, "postal code");
        this.country = nonEmptyValidator.validate(country, "country");
        this.phoneNumber = nonEmptyValidator.validate(phoneNumber, "phone number");
        this.type = nonNullValidator.validate(type, "type");
        this.primaryAddress = primaryAddress;
    }

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
