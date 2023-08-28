package co.crisi.shipm8.mapper.jdbc;

import co.crisi.shipm8.domain.IShopper;
import co.crisi.shipm8.entity.jdbc.ShopperJDBCEntity;
import org.mapstruct.Mapper;

@Mapper
public interface ShopperJDBCMapper {

    ShopperJDBCEntity map(IShopper shopper);

}
