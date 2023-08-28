package co.crisi.shipm8.config;

import co.crisi.shipm8.port.api.IProductServicePort;
import co.crisi.shipm8.port.spi.IProductPersistencePort;
import co.crisi.shipm8.service.ProductServicePort;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProductBeanConfig {

    @Bean
    public IProductServicePort productServicePort(
            @Qualifier("productPersistenceJPAAdapter")
                    IProductPersistencePort persistencePort) {
        return new ProductServicePort(persistencePort);
    }

}
