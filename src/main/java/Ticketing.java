import javax.persistence.*;
import java.util.List;

@Entity
public class Ticketing {
    @Id
    @Column(name = "TICKETING_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;
    @ManyToOne
    @JoinColumn(name = "SCREENING_ID")
    private Screening screening;
}
