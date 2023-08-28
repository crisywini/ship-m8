package co.crisi.shipm8.mapper.jpa;

import co.crisi.shipm8.domain.IOrder;
import co.crisi.shipm8.entity.jpa.OrderJPAEntity;
import org.mapstruct.Mapper;

@Mapper(uses = AddressJPAMapper.class)
public interface OrderJPAMapper {

    OrderJPAEntity map(IOrder order);

}
