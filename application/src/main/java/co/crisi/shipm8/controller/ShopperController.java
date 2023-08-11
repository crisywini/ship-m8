package co.crisi.shipm8.controller;

import co.crisi.shipm8.domain.data.Shopper;
import co.crisi.shipm8.mapper.ShopperDtoMapper;
import co.crisi.shipm8.model.ShopperDto;
import co.crisi.shipm8.port.api.IShopperServicePort;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
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
    

}
