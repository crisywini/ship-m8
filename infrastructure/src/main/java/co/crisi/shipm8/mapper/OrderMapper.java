package co.crisi.shipm8.mapper;

import co.crisi.shipm8.domain.IOrder;
import co.crisi.shipm8.entity.jdbc.OrderJDBCEntity;
import org.mapstruct.Mapper;

@Mapper
public interface OrderMapper {

    OrderJDBCEntity map(IOrder order);

}
