import javax.persistence.*;
import java.util.List;

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
}
