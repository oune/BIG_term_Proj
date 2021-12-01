import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;

@NoArgsConstructor
@Entity
@Getter
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
    @ManyToOne
    private Director director;
    @OneToMany
    @JoinColumn(name="PARTICIPATION_ID")
    private List<Participation> actors = new ArrayList<>();

    public Movie(String title, LocalDate openDate, Genre genre, int time, Director director) {
        this.title = title;
        this.openDate = openDate;
        this.genre = genre;
        this.time = time;
        this.director = director;
    }

    private String getActorsInfo() {
        StringBuilder sb = new StringBuilder();
        actors.forEach((actor) -> {
            sb.append(actor.getInfo());
            sb.append("\n");
        });

        return sb.toString();
    }

    public String getInfo() {
        return "제목 : " + title + "\n"
                + "개봉일 : " + openDate + "\n"
                + "장르 : " + genre + "\n"
                + "러닝타임 : " + time + "\n"
                + "감독 : " + director.getInfo() + "\n"
                + getActorsInfo();
    }
}
