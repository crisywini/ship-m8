package co.crisi.shipm8.mapper.jdbc;

import co.crisi.shipm8.domain.IDiscount;
import co.crisi.shipm8.entity.jdbc.DiscountJDBCEntity;
import org.mapstruct.Mapper;

@Mapper
public interface DiscountJDBCMapper {

    DiscountJDBCEntity map(IDiscount discount);

}
