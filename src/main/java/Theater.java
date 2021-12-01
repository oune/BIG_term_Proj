import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@Entity
public class Theater {
    @Id
    @Column(name = "THEATER_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private String name;
    @Column
    private int floor;

    public Theater(String name, int floor) {
        this.name = name;
        this.floor = floor;
    }
}
