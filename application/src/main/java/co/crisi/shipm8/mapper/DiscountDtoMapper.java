package co.crisi.shipm8.mapper;

import co.crisi.shipm8.domain.IDiscount;
import co.crisi.shipm8.model.DiscountDto;
import java.util.List;
import org.mapstruct.Mapper;

@Mapper
public interface DiscountDtoMapper {

    DiscountDto map(IDiscount discount);

    List<DiscountDto> map(List<IDiscount> discounts);

}
