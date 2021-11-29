import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.time.LocalDate;

@MappedSuperclass
public class BaseEntityCreateUpdateTime {
    @Column(name = "CREATE_DATE")
    private LocalDate create;
    @Column(name = "UPDATE_DATE")
    private LocalDate update;
}
