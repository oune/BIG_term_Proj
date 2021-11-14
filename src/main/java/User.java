import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class User {
    @Id
    @Column(name = "USER_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private String name;
    @Column
    private int age;
    @Column
    private String address;
    @Column(name = "CREATE_DATE")
    private LocalDate create;
    @Column(name = "UPDATE_DATE")
    private LocalDate update;
}
