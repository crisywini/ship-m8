package co.crisi.shipm8.domain;

public enum DiscountType {
    PERCENTAGE_OFF(1),
    FIXED_AMOUNT_OFF(2),
    BUY_ONE_GET_ONE_FREE(3);

    private final Integer id;

    DiscountType(Integer id) {
        this.id = id;
    }
}
