package co.crisi.shipm8.controller;

import co.crisi.shipm8.domain.data.Address;
import co.crisi.shipm8.mapper.AddressDtoMapper;
import co.crisi.shipm8.model.AddressDto;
import co.crisi.shipm8.port.api.IAddressServicePort;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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
@RequestMapping("/addresses")
@RequiredArgsConstructor
public class AddressController {

    private final IAddressServicePort servicePort;

    private final AddressDtoMapper mapper = Mappers.getMapper(AddressDtoMapper.class);

    @PostMapping
    @Operation(summary = "Creates a new Address")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Address Created")
    })
    public ResponseEntity<AddressDto> save(
            @RequestBody
                    Address address) {
        return ResponseEntity.ok(mapper.map(servicePort.save(address)));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Find an Address by its Id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Address Found")
    })
    public ResponseEntity<AddressDto> findById(
            @PathVariable(name = "id")
                    Long id) {
        return new ResponseEntity<>(mapper.map(servicePort.getById(id)), HttpStatus.CREATED);
    }


    @GetMapping
    @Operation(summary = "Find all Addresses")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Addresses Found")
    })
    public ResponseEntity<List<AddressDto>> findAll() {
        return ResponseEntity.ok(mapper.map(servicePort.getAll()));
    }


    @DeleteMapping("/{id}")
    @Operation(summary = "Deletes an Address by its Id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Address Deleted")
    })
    public ResponseEntity<Void> deleteById(
            @PathVariable(name = "id")
                    Long id) {
        servicePort.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
