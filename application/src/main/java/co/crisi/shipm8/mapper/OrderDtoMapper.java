package co.crisi.shipm8.mapper;

import co.crisi.shipm8.domain.IOrder;
import co.crisi.shipm8.model.OrderDto;
import java.util.List;
import org.mapstruct.Mapper;

@Mapper(uses = ProductDtoMapper.class)
public interface OrderDtoMapper {

    OrderDto map(IOrder order);

    List<OrderDto> map(List<IOrder> orders);

}
