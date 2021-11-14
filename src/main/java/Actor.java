import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Actor extends Person{
    private int height;
    private String instagram;
}
