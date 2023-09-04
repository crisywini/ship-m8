package co.crisi.shipm8.domain.message;


import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public record OrderDto(@JsonProperty("orderId") Long orderId,
                       @JsonProperty("products") List<ProductUpdateDto> products) {


}