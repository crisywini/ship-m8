package co.crisi.shipm8.controller;

import co.crisi.shipm8.domain.data.Product;
import co.crisi.shipm8.mapper.ProductDtoMapper;
import co.crisi.shipm8.model.ProductDto;
import co.crisi.shipm8.port.api.IProductServicePort;
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
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final IProductServicePort servicePort;

    private final ProductDtoMapper mapper = Mappers.getMapper(ProductDtoMapper.class);


    @PostMapping
    public ResponseEntity<ProductDto> save(Product product) {
        return new ResponseEntity<>(mapper.map(servicePort.save(product)), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ProductDto>> findAll() {
        return ResponseEntity.ok(mapper.map(servicePort.getAll()));
    }


    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> findById(
            @PathVariable(name = "id")
                    Long id) {
        return ResponseEntity.ok(mapper.map(servicePort.getById(id)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(
            @PathVariable(name = "id")
                    Long id) {
        servicePort.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
