package co.crisi.shipm8.mapper.jpa;

import co.crisi.shipm8.domain.IAddress;
import co.crisi.shipm8.entity.jpa.AddressJPAEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface AddressJPAMapper {

    @Mapping(target = "shopper", ignore = true)
    AddressJPAEntity map(IAddress address);

}
