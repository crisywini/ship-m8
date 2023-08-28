package co.crisi.shipm8.mapper;

import co.crisi.shipm8.domain.IProduct;
import co.crisi.shipm8.entity.jdbc.ProductJDBCEntity;
import org.mapstruct.Mapper;

@Mapper
public interface ProductMapper {

    ProductJDBCEntity map(IProduct product);

}
