package co.crisi.shipm8.domain.mapper;

import co.crisi.shipm8.domain.IAddress;
import co.crisi.shipm8.domain.IProduct;
import co.crisi.shipm8.domain.data.Address;
import co.crisi.shipm8.domain.data.Order;
import co.crisi.shipm8.domain.data.Product;
import co.crisi.shipm8.domain.data.input.OrderSaveDto;
import java.util.List;
import org.mapstruct.Mapper;

@Mapper
public interface OrderMapper {

    Order map(OrderSaveDto orderSaveDto);

}
