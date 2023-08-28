package co.crisi.shipm8.mapper.jpa;

import co.crisi.shipm8.domain.IProduct;
import co.crisi.shipm8.entity.jpa.ProductJPAEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface ProductJPAMapper {

    @Mapping(target = "order", ignore = true)
    ProductJPAEntity map(IProduct product);

}
