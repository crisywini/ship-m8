package co.crisi.shipm8.mapper.jdbc;

import co.crisi.shipm8.domain.IAddress;
import co.crisi.shipm8.entity.jdbc.AddressJDBCEntity;
import org.mapstruct.Mapper;

@Mapper
public interface AddressJDBCMapper {


    AddressJDBCEntity map(IAddress address);

}
