package co.crisi.shipm8.mapper.jpa;

import co.crisi.shipm8.domain.IAddress;
import co.crisi.shipm8.entity.jpa.AddressJPAEntity;
import org.mapstruct.Mapper;

@Mapper
public interface AddressJPAMapper {

    AddressJPAEntity map(IAddress address);

}
