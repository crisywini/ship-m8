package co.crisi.shipm8.controller;

import co.crisi.shipm8.domain.data.Address;
import co.crisi.shipm8.mapper.AddressDtoMapper;
import co.crisi.shipm8.model.AddressDto;
import co.crisi.shipm8.port.api.IAddressServicePort;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/addresses")
@RequiredArgsConstructor
public class AddressController {

    private final IAddressServicePort servicePort;

    private final AddressDtoMapper mapper = Mappers.getMapper(AddressDtoMapper.class);

    @PostMapping
    public ResponseEntity<AddressDto> save(
            @RequestBody
                    Address address) {
        return ResponseEntity.ok(mapper.map(servicePort.save(address)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AddressDto> findById(
            @PathVariable(name = "id")
                    Long id) {
        return ResponseEntity.ok(mapper.map(servicePort.getById(id)));
    }


    @GetMapping
    public ResponseEntity<List<AddressDto>> findAll() {
        return ResponseEntity.ok(mapper.map(servicePort.getAll()));
    }




}
