package co.crisi.shipm8.mapper;

import co.crisi.shipm8.domain.IAddress;
import co.crisi.shipm8.entity.jdbc.AddressJDBCEntity;
import org.mapstruct.Mapper;

@Mapper
public interface AddressMapper {


    AddressJDBCEntity map(IAddress address);

}
