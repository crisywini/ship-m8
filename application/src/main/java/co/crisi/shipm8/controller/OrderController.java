package co.crisi.shipm8.controller;

import co.crisi.shipm8.domain.data.Order;
import co.crisi.shipm8.mapper.OrderDtoMapper;
import co.crisi.shipm8.model.OrderDto;
import co.crisi.shipm8.port.api.IOrderServicePort;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

    private final IOrderServicePort servicePort;

    private final OrderDtoMapper mapper = Mappers.getMapper(OrderDtoMapper.class);


    @PostMapping
    public ResponseEntity<OrderDto> save(
            @RequestBody
                    Order order) {
        return new ResponseEntity<>(mapper.map(servicePort.save(order)), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderDto> findById(
            @PathVariable(name = "id")
                    Long id) {
        return ResponseEntity.ok(mapper.map(servicePort.getById(id)));
    }


}
