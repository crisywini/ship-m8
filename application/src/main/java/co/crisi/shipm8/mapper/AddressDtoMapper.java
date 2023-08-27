package co.crisi.shipm8.mapper;

import co.crisi.shipm8.domain.IAddress;
import co.crisi.shipm8.model.AddressDto;
import java.util.List;
import org.mapstruct.Mapper;

@Mapper
public interface AddressDtoMapper {

    AddressDto map(IAddress address);

    List<AddressDto> map(List<IAddress> addresses);

}
