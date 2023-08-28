package co.crisi.shipm8.mapper;

import co.crisi.shipm8.domain.IShopper;
import co.crisi.shipm8.entity.jdbc.ShopperJDBCEntity;
import org.mapstruct.Mapper;

@Mapper
public interface ShopperMapper {

    ShopperJDBCEntity map(IShopper shopper);

}
