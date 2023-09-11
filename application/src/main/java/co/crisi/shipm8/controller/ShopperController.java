package co.crisi.shipm8.controller;

import co.crisi.shipm8.domain.data.Shopper;
import co.crisi.shipm8.mapper.ShopperDtoMapper;
import co.crisi.shipm8.model.ShopperDto;
import co.crisi.shipm8.port.api.IShopperServicePort;
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
@RequestMapping("/shoppers")
@RequiredArgsConstructor
public class ShopperController {

    private final IShopperServicePort servicePort;

    private ShopperDtoMapper mapper = Mappers.getMapper(ShopperDtoMapper.class);

    @PostMapping
    @Operation(summary = "Creates a new Shopper")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Shopper Created")
    })
    public ResponseEntity<ShopperDto> save(
            @RequestBody
                    Shopper shopper) {
        return new ResponseEntity<>(mapper.map(servicePort.save(shopper)), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Find a Shopper by its Id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Shopper Found")
    })
    public ResponseEntity<ShopperDto> findById(
            @PathVariable(name = "id")
                    Long id) {
        return ResponseEntity.ok(mapper.map(servicePort.getById(id)));
    }

    @GetMapping
    @Operation(summary = "Find all Products")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Products Found")
    })
    public ResponseEntity<List<ShopperDto>> findAll() {
        return ResponseEntity.ok(mapper.map(servicePort.getAll()));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a Product by its Id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Product Deleted")
    })
    public ResponseEntity<Void> deleteById(
            @PathVariable(name = "id")
                    Long id) {
        servicePort.deleteById(id);
        return ResponseEntity.ok().build();
    }


}
