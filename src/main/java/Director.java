import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Director extends Person{
    @Column
    private String birthPlace;
}
