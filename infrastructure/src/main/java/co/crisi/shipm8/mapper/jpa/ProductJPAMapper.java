package co.crisi.shipm8.mapper.jpa;

import co.crisi.shipm8.domain.IProduct;
import co.crisi.shipm8.entity.jpa.ProductJPAEntity;
import org.mapstruct.Mapper;

@Mapper
public interface ProductJPAMapper {

    ProductJPAEntity map(IProduct product);

}
