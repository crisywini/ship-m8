package co.crisi.shipm8.controller;

import co.crisi.shipm8.domain.data.Discount;
import co.crisi.shipm8.mapper.DiscountDtoMapper;
import co.crisi.shipm8.model.DiscountDto;
import co.crisi.shipm8.port.api.IDiscountServicePort;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/discounts")
@RequiredArgsConstructor
public class DiscountController {

    private final IDiscountServicePort servicePort;

    private final DiscountDtoMapper mapper = Mappers.getMapper(DiscountDtoMapper.class);

    @PostMapping
    public ResponseEntity<DiscountDto> save(
            @RequestBody
                    Discount discount) {
        return new ResponseEntity<>(mapper.map(servicePort.save(discount)), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<DiscountDto>> findAll(){
        return ResponseEntity.ok(mapper.map(servicePort.getAll()));
    }

    @GetMapping
    public ResponseEntity<DiscountDto> findById(Long id){
        return ResponseEntity.ok(mapper.map(servicePort.getById(id)));
    }

}
