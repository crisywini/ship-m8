package co.crisi.shipm8.config;

import co.crisi.shipm8.domain.event.OrderProcessed;
import co.crisi.shipm8.port.api.IOrderServicePort;
import co.crisi.shipm8.port.spi.IAddressPersistencePort;
import co.crisi.shipm8.port.spi.IOrderPersistencePort;
import co.crisi.shipm8.port.spi.IProductPersistencePort;
import co.crisi.shipm8.port.spi.ISendMessagePort;
import co.crisi.shipm8.port.spi.IShopperPersistencePort;
import co.crisi.shipm8.service.OrderServicePort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OrderBeanConfig {


    @Bean
    public IOrderServicePort orderServicePort(IOrderPersistencePort persistencePort,
            IAddressPersistencePort addressPersistencePort, IProductPersistencePort productPersistencePort,
            IShopperPersistencePort shopperPersistencePort, ISendMessagePort<OrderProcessed> sendMessagePort) {
        return new OrderServicePort(persistencePort, addressPersistencePort, productPersistencePort,
                shopperPersistencePort, sendMessagePort);
    }

}
