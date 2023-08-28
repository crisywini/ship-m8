package co.crisi.shipm8.mapper.jpa;

import co.crisi.shipm8.domain.IShopper;
import co.crisi.shipm8.entity.jpa.ShopperJPAEntity;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(uses = AddressJPAMapper.class)
public interface ShopperJPAMapper {

    ShopperJPAEntity map(IShopper shopper);

    @AfterMapping
    default void setOrderReference(
            @MappingTarget
                    ShopperJPAEntity entity) {
        entity.getAddresses()
                .forEach(address -> address.setShopper(entity));
    }

}
