package co.crisi.shipm8.model;


import co.crisi.shipm8.domain.data.Role;
import java.time.LocalDate;
import java.util.List;
import lombok.Builder;

@Builder(toBuilder = true)
public record ShopperDto(Long id, String firstName, String lastName, String email,
                         String password, String phoneNumber, LocalDate dateOfBirth,
                         String gender, LocalDate registrationDate, Role role, Boolean activeStatus,
                         String profilePicture, List<AddressDto> addresses) {

}
