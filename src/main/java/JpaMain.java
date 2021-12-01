import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.time.LocalDate;

public class JpaMain {
    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("movie");

    public static void main(String[] args) {
        createMovieInfo();

        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();

            Movie findMovie = em.find(Movie.class, 1L);
            System.out.println(findMovie);

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
        emf.close();
    }

    public static void createMovieInfo() {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            Director director = new Director("토니", LocalDate.of(2020, 3, 20), "미국");
            Movie movie = new Movie("아이언맨", LocalDate.of(2020, 3, 20), Genre.Action, 40, director);
            Actor actor = new Actor("배우", LocalDate.of(2020, 3, 20), 180, "@멋진배우");
            Participation attempt = new Participation(movie, actor, "주연");

            em.persist(movie);
            em.persist(actor);
            em.persist(director);
            em.persist(attempt);

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    public static void createUser(String name, Integer age, String city, String street, String zipCode) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();

            User user = new User(name, age, city, street, zipCode);
            em.persist(user);

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    public static void setUser() {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            User user = new User("이준재", 22, "원주시", "남산로", "22932");
            em.persist(user);
            user.setAddress(new Address("구미시", "거의동", "21312"));
            em.persist(user);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }
}
