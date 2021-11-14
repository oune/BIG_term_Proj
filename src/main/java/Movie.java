import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Movie {
    @Id
    @Column(name = "MOVIE_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private String title;
    @Column
    private LocalDate openDate;
    @Column
    @Enumerated(EnumType.STRING)
    private Genre genre;
    @Column
    private int time;
}
