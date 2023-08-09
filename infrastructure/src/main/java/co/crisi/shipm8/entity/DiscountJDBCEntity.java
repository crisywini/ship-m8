package co.crisi.shipm8.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class DiscountJDBCEntity {

    @Id
    private Long id;

}
