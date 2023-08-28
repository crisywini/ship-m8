package co.crisi.shipm8.mapper.jpa;

import co.crisi.shipm8.domain.IOrder;
import co.crisi.shipm8.entity.jpa.OrderJPAEntity;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(uses = {AddressJPAMapper.class, ProductJPAMapper.class, ShopperJPAMapper.class})
public interface OrderJPAMapper {

    OrderJPAEntity map(IOrder order);


    @AfterMapping
    default void setOrderReferenceToProduct(
            @MappingTarget
                    OrderJPAEntity entity) {
        entity.getProducts()
                .forEach(p -> p.setOrder(entity));
    }

}
