package co.crisi.shipm8.config;

import co.crisi.shipm8.adapter.jdbc.OrderPersistenceJDBCAdapter;
import co.crisi.shipm8.port.api.IOrderServicePort;
import co.crisi.shipm8.port.spi.IOrderPersistencePort;
import co.crisi.shipm8.repository.jdbc.OrderJDBCRepository;
import co.crisi.shipm8.service.OrderServicePort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OrderBeanConfig {

    @Bean
    public IOrderServicePort orderServicePort(IOrderPersistencePort persistencePort) {
        return new OrderServicePort(persistencePort);
    }

    @Bean
    public IOrderPersistencePort orderPersistencePort(OrderJDBCRepository repository) {
        return new OrderPersistenceJDBCAdapter(repository);
    }

}
