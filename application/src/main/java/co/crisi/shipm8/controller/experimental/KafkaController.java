package co.crisi.shipm8.controller.experimental;

import co.crisi.shipm8.port.spi.ISendMessagePort;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test")
@RequiredArgsConstructor
public class KafkaController {

    private final ISendMessagePort messagePort;


    @PostMapping
    public ResponseEntity<Void> sendMessage(@RequestBody String message){
        messagePort.sendMessage(message);
        return ResponseEntity.ok().build();
    }

}
