package co.crisi.shipm8.model;

import co.crisi.shipm8.domain.data.AddressType;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

@Builder(toBuilder = true)
@Schema(description = "Address Model Info")
public record AddressDto(Long id, String recipientName, String streetAddress, String city, String stateProvinceRegion,
                         String postalCode, String country, String phoneNumber, AddressType type,
                         Boolean primaryAddress) {

}
