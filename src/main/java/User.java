import javax.persistence.*;

@Entity
public class User extends BaseEntityCreateUpdateTime {
    @Id
    @Column(name = "USER_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private String name;
    @Column
    private int age;
    @Embedded
    private Address address;
}
