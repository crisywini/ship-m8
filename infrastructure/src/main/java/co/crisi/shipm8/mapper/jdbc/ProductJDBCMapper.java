package co.crisi.shipm8.mapper.jdbc;

import co.crisi.shipm8.domain.IProduct;
import co.crisi.shipm8.entity.jdbc.ProductJDBCEntity;
import org.mapstruct.Mapper;

@Mapper
public interface ProductJDBCMapper {

    ProductJDBCEntity map(IProduct product);

}
