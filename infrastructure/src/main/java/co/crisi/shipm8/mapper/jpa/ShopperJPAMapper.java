package co.crisi.shipm8.mapper.jpa;

import co.crisi.shipm8.domain.IShopper;
import co.crisi.shipm8.entity.jpa.ShopperJPAEntity;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(uses = AddressJPAMapper.class)
public interface ShopperJPAMapper {

    @Mapping(target = "orders", ignore = true)
    ShopperJPAEntity map(IShopper shopper);

    @AfterMapping
    default void setShopperReferenceToAddress(
            @MappingTarget
                    ShopperJPAEntity entity) {
        entity.getAddresses()
                .forEach(address -> address.setShopper(entity));
    }

}
