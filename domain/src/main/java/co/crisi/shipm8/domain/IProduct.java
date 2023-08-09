package co.crisi.shipm8.domain;

import co.crisi.shipm8.domain.data.Discount;
import java.util.List;

public interface IProduct {

    Long getId();

    Long getProductId();

    Integer getQuantity();

    Double getPricePerUnit();

    Double getTotalPrice();

    List<Discount> getDiscounts();

    Double getTax();

}
