package co.crisi.shipm8.domain;

public enum AddressType {
    PRIMARY(1),
    SHIPPING(2),
    BILLING(3);

    private final Integer id;

    AddressType(Integer id) {
        this.id = id;
    }
}
