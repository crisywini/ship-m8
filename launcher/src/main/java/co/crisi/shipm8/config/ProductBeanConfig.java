package co.crisi.shipm8.config;

import co.crisi.shipm8.adapter.jdbc.ProductPersistenceJDBCAdapter;
import co.crisi.shipm8.port.api.IProductServicePort;
import co.crisi.shipm8.port.spi.IProductPersistencePort;
import co.crisi.shipm8.repository.jdbc.ProductJDBCRepository;
import co.crisi.shipm8.service.ProductServicePort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProductBeanConfig {

    @Bean
    public IProductServicePort productServicePort(IProductPersistencePort persistencePort) {
        return new ProductServicePort(persistencePort);
    }

    @Bean
    public IProductPersistencePort productPersistencePort(ProductJDBCRepository repository) {
        return new ProductPersistenceJDBCAdapter(repository);
    }

}
