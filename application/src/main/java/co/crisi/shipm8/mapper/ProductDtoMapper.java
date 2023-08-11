package co.crisi.shipm8.mapper;

import co.crisi.shipm8.domain.IProduct;
import co.crisi.shipm8.model.ProductDto;
import java.util.List;
import org.mapstruct.Mapper;

@Mapper
public interface ProductDtoMapper {

    ProductDto map(IProduct product);

    List<ProductDto> map(List<IProduct> products);

}
