package co.crisi.shipm8.adapter.kafka;

import co.crisi.shipm8.port.spi.message.ISendMessagePort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;

@Slf4j
//Component
@RequiredArgsConstructor
public class KafkaProducerAdapter implements ISendMessagePort<String> {

    private final KafkaTemplate<String, String> kafkaTemplate;

    @Override
    public void sendMessage(String message) {
        var future = kafkaTemplate.send("third_topic", message);
        log.info("message sent...");

        future.whenComplete((result, ex) -> {
            if (ex == null) {
                log.debug("Sent message=[" + message +
                        "] with offset=[" + result.getRecordMetadata().offset() + "]");
            } else {
                log.error("Unable to send message=[" +
                        message + "] due to : " + ex.getMessage());
            }
        });

        kafkaTemplate.flush();
    }

}
