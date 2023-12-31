package co.crisi.shipm8.controller;

import co.crisi.shipm8.domain.data.Discount;
import co.crisi.shipm8.mapper.DiscountDtoMapper;
import co.crisi.shipm8.model.DiscountDto;
import co.crisi.shipm8.port.api.IDiscountServicePort;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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

@Slf4j
@Controller
@RequestMapping("/discounts")
@RequiredArgsConstructor
public class DiscountController {

    private final IDiscountServicePort servicePort;

    private final DiscountDtoMapper mapper = Mappers.getMapper(DiscountDtoMapper.class);

    @PostMapping
    @Operation(summary = "Creates a new Discount")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Discount Created")
    })
    public ResponseEntity<DiscountDto> save(
            @RequestBody
                    Discount discount) {
        log.debug("discount {}", discount);
        return new ResponseEntity<>(mapper.map(servicePort.save(discount)), HttpStatus.CREATED);
    }

    @GetMapping
    @Operation(summary = "Find all Discounts")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Discounts Found")
    })
    public ResponseEntity<List<DiscountDto>> findAll() {
        return ResponseEntity.ok(mapper.map(servicePort.getAll()));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Find a Discount by its Id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Discount Found")
    })
    public ResponseEntity<DiscountDto> findById(
            @PathVariable(name = "id")
                    Long id) {
        return ResponseEntity.ok(mapper.map(servicePort.getById(id)));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a Discount by its Id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Discount Deleted")
    })
    public ResponseEntity<Void> deleteById(
            @PathVariable(name = "id")
                    Long id) {
        servicePort.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
