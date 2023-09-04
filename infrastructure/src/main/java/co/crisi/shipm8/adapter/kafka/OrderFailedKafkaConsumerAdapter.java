package co.crisi.shipm8.adapter.kafka;

import co.crisi.shipm8.domain.message.OrderFailed;
import co.crisi.shipm8.domain.message.Topics;
import co.crisi.shipm8.port.spi.message.IReceiveMessagePort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Component
@RequiredArgsConstructor
public class OrderFailedKafkaConsumerAdapter implements IReceiveMessagePort<OrderFailed> {

    @Transactional
    @KafkaListener(id = "id", topics = Topics.EXCEPTION)
    @Override
    public void listen(OrderFailed message) {
        log.info("Processing order failed message! {} ", message.getFailedOrder());
    }

}
