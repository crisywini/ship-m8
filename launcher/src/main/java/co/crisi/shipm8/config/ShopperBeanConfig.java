package co.crisi.shipm8.config;

import co.crisi.shipm8.adapter.jdbc.ShopperPersistenceJDBCAdapter;
import co.crisi.shipm8.port.api.IShopperServicePort;
import co.crisi.shipm8.port.spi.IShopperPersistencePort;
import co.crisi.shipm8.repository.jdbc.ShopperJDBCRepository;
import co.crisi.shipm8.service.ShopperServicePort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ShopperBeanConfig {


    @Bean
    public IShopperServicePort shopperServicePort(IShopperPersistencePort persistencePort) {
        return new ShopperServicePort(persistencePort);
    }

    @Bean
    public IShopperPersistencePort shopperPersistencePort(ShopperJDBCRepository repository) {
        return new ShopperPersistenceJDBCAdapter(repository);
    }

}