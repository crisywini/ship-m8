package co.crisi.shipm8.mapper;

import co.crisi.shipm8.domain.IDiscount;
import co.crisi.shipm8.entity.jdbc.DiscountJDBCEntity;
import org.mapstruct.Mapper;

@Mapper
public interface DiscountMapper {

    DiscountJDBCEntity map(IDiscount discount);

}
