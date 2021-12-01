import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor
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

    public Screening(Movie movie, Theater theater, LocalDateTime start, LocalDateTime end) {
        this.movie = movie;
        this.theater = theater;
        this.start = start;
        this.end = end;
    }
}
