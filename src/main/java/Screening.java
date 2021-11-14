import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Screening {
    @Id
    @Column(name = "SCREENING_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    @JoinColumn(name = "MOVIE_ID")
    private Movie movie;
    @ManyToOne
    @JoinColumn(name = "THEATER_ID")
    private Theater theater;
    @Column
    private LocalDateTime start;
    @Column
    private LocalDateTime end;

    public Screening() {
    }
}
