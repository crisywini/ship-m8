package co.crisi.shipm8.mapper.jpa;

import co.crisi.shipm8.domain.IDiscount;
import co.crisi.shipm8.entity.jpa.DiscountJPAEntity;
import org.mapstruct.Mapper;

@Mapper
public interface DiscountJPAMapper {

    DiscountJPAEntity map(IDiscount discount);

}
