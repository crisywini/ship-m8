package co.crisi.shipm8.domain.data;

public enum Role {
    CUSTOMER(100),
    ADMIN(200),
    SELLER(300);

    private final Integer id;

    Role(Integer id) {
        this.id = id;
    }

}
