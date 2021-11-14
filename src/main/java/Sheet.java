import javax.persistence.*;

@Entity
public class Sheet {
    @Id
    @Column(name = "SHEET_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "ROW_IDX")
    private int row;

    @Column(name = "COLUMN_IDX")
    private int column;

    @Column(name = "STATE")
    private String condition;

    @ManyToOne
    @JoinColumn(name = "THEATER_ID")
    private Theater theater;

    @ManyToOne
    @JoinColumn(name = "TICKETING_ID")
    private Ticketing ticketing;
}
