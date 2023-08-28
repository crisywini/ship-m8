package co.crisi.shipm8.mapper.jpa;

import co.crisi.shipm8.domain.IShopper;
import co.crisi.shipm8.entity.jpa.ShopperJPAEntity;
import org.mapstruct.Mapper;

@Mapper(uses = AddressJPAMapper.class)
public interface ShopperJPAMapper {

    ShopperJPAEntity map(IShopper shopper);

}
