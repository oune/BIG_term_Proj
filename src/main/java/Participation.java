import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Participation {
    @Id
    @Column(name = "PARTICIPATION_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "MOVIE_ID")
    private Movie movie;

    @ManyToOne
    @JoinColumn(name = "PERSON_ID")
    private Person person;
    @Column
    private String rule;
}
