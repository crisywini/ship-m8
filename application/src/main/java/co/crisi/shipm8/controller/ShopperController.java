package co.crisi.shipm8.controller;

import co.crisi.shipm8.domain.data.Shopper;
import co.crisi.shipm8.mapper.ShopperDtoMapper;
import co.crisi.shipm8.model.ShopperDto;
import co.crisi.shipm8.port.api.IShopperServicePort;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/shoppers")
@RequiredArgsConstructor
public class ShopperController {

    private final IShopperServicePort servicePort;

    private ShopperDtoMapper mapper = Mappers.getMapper(ShopperDtoMapper.class);

    @PostMapping
    public ResponseEntity<ShopperDto> save(
            @RequestBody
                    Shopper shopper) {
        return new ResponseEntity<>(mapper.map(servicePort.save(shopper)), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ShopperDto> findById(
            @PathVariable(name = "id")
                    Long id) {
        return ResponseEntity.ok(mapper.map(servicePort.getById(id)));
    }

    @GetMapping
    public ResponseEntity<List<ShopperDto>> findAll() {
        return ResponseEntity.ok(mapper.map(servicePort.getAll()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(
            @PathVariable(name = "id")
                    Long id) {
        servicePort.deleteById(id);
        return ResponseEntity.ok().build();
    }


}
