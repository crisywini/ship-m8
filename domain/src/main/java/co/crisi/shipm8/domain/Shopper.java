package co.crisi.shipm8.domain;

import java.time.LocalDate;
import java.util.List;
import org.apache.kafka.common.protocol.types.Field.Bool;
import org.springframework.cglib.core.Local;

public record Shopper(Long id, String firstName, String lastName, String email,
                      String password, Integer phoneNumber, LocalDate dateOfBirth,
                      String gender, LocalDate registrationDate,
                      Local lastLoginDate, Role role, Bool activeStatus,
                      String profilePicture, List<Order> orders, List<Address> addresses) {

}
