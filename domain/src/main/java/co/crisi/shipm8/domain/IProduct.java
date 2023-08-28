package co.crisi.shipm8.domain;

import java.util.List;

public interface IProduct {

    Long getId();

    Long getProductId();

    Integer getQuantity();

    Double getPricePerUnit();

    Double getTotalPrice();

    List<? extends IDiscount> getDiscounts();

    Double getTax();

}
