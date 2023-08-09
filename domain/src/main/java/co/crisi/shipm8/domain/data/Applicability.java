package co.crisi.shipm8.domain.data;

public enum Applicability {
    ORDERS(1),
    PRODUCTS(2),
    BOTH(3);

    private final Integer id;

    Applicability(Integer id) {
        this.id = id;
    }
}
