package co.crisi.shipm8.config;

import co.crisi.shipm8.port.api.IDiscountServicePort;
import co.crisi.shipm8.port.spi.IDiscountPersistencePort;
import co.crisi.shipm8.service.DiscountServicePort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DiscountBeanConfig {

    @Bean
    public IDiscountServicePort discountServicePort(IDiscountPersistencePort persistencePort) {
        return new DiscountServicePort(persistencePort);
    }


}
