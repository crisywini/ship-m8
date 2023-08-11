package co.crisi.shipm8.mapper;

import co.crisi.shipm8.domain.IShopper;
import co.crisi.shipm8.model.ShopperDto;
import java.util.List;
import org.mapstruct.Mapper;

@Mapper(uses = AddressDtoMapper.class)
public interface ShopperDtoMapper {

    ShopperDto map(IShopper shopper);

    List<ShopperDto> map(List<IShopper> shoppers);

}
