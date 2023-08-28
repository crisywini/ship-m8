package co.crisi.shipm8.config;

import co.crisi.shipm8.port.api.IAddressServicePort;
import co.crisi.shipm8.port.spi.IAddressPersistencePort;
import co.crisi.shipm8.service.AddressServicePort;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AddressBeanConfig {

    @Bean
    public IAddressServicePort servicePort(
            @Qualifier("addressPersistenceJPAAdapter")
                    IAddressPersistencePort persistencePort) {
        return new AddressServicePort(persistencePort);
    }


}
