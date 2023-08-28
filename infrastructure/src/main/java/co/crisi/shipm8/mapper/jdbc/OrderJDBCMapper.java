package co.crisi.shipm8.mapper.jdbc;

import co.crisi.shipm8.domain.IOrder;
import co.crisi.shipm8.entity.jdbc.OrderJDBCEntity;
import org.mapstruct.Mapper;

@Mapper
public interface OrderJDBCMapper {

    OrderJDBCEntity map(IOrder order);

}
