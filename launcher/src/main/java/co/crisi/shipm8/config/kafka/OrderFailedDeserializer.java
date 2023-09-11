package co.crisi.shipm8.config.kafka;

import co.crisi.shipm8.domain.message.OrderFailed;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Map;
import org.apache.kafka.common.serialization.Deserializer;

public class OrderFailedDeserializer implements Deserializer<OrderFailed> {

    @Override
    public void close() {

    }

    @Override
    public void configure(Map<String, ?> arg0, boolean arg1) {

    }

    @Override
    public OrderFailed deserialize(String arg0, byte[] arg1) {
        ObjectMapper mapper = new ObjectMapper();
        OrderFailed orderProcessed = null;
        try {
            orderProcessed = mapper.readValue(arg1, OrderFailed.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return orderProcessed;
    }


}
