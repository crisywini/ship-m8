package co.crisi.shipm8.adapter.kafka;

import co.crisi.shipm8.domain.event.OrderProcessed;
import co.crisi.shipm8.domain.event.Topics;
import co.crisi.shipm8.port.spi.ISendMessagePort;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class KafkaProducerOrderAdapter implements ISendMessagePort<OrderProcessed> {

    private final KafkaTemplate<String, OrderProcessed> kafkaTemplate;

    @Override
    public void sendMessage(OrderProcessed message) {
        kafkaTemplate.send(Topics.THIRD_TOPIC, message);
        kafkaTemplate.flush();
    }

}
