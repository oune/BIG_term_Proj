import com.querydsl.jpa.impl.JPAQueryFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.util.List;

public class JpaMain {
    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("movie");

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();

            Director director = new Director("토니", LocalDate.of(2020, 3, 20), "미국");
            Movie movie = new Movie("아이언맨", LocalDate.of(2020, 3, 20), Genre.Action, 40, director);



            em.persist(movie);
            em.persist(director);

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }

        emf.close();
    }

    public static void num5() {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();

            Director director = new Director("토니", LocalDate.of(2020, 3, 20), "미국");
            Movie movie = new Movie("아이언맨", LocalDate.of(2020, 3, 20), Genre.Action, 40, director);
            Movie movie1 = new Movie("아이언맨2", LocalDate.of(2010, 3, 21), Genre.Action, 20, director);
            Movie movie2 = new Movie("아이언맨3", LocalDate.of(2010, 3, 21), Genre.Action, 20, director);
            Movie movie3 = new Movie("아이언맨4", LocalDate.of(2010, 3, 21), Genre.Action, 20, director);
            Movie movie4 = new Movie("아이언맨5", LocalDate.of(2010, 3, 21), Genre.Action, 20, director);
            Movie movie5 = new Movie("아이언맨6", LocalDate.of(2010, 3, 21), Genre.Action, 20, director);


            em.persist(movie);
            em.persist(movie1);
            em.persist(movie2);
            em.persist(movie3);
            em.persist(movie4);
            em.persist(movie5);

            em.persist(director);

            tx.commit();

            QMovie qMovie = new QMovie("m");
            JPAQueryFactory query = new JPAQueryFactory(em);
            List<Movie> movies = query.selectFrom(qMovie)
                    .offset(0)
                    .limit(2)
                    .fetch();

            for (Movie m : movies) {
                System.out.println(m.getInfo());
            }
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    public static void num4() {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        Director director = null;
        Actor actor = null;
        try {
            tx.begin();
            director = new Director("토니", LocalDate.of(2020, 3, 20), "미국");
            Movie movie = new Movie("아이언맨", LocalDate.of(2020, 3, 20), Genre.Action, 40, director);
            Movie movie1 = new Movie("아이언맨2", LocalDate.of(2010, 3, 21), Genre.Action, 20, director);
            actor = new Actor("배우", LocalDate.of(2020, 3, 10), 180, "@멋진배우");
            Participation attempt = new Participation(movie, actor, "주연");

            em.persist(movie);
            em.persist(movie1);
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

        findMovieWithWorkerOpeningDateRunningTime(director, actor, LocalDate.of(2020, 3, 20));
    }

    public static void findMovieWithWorkerOpeningDateRunningTime(Director director, Actor actor, LocalDate openingDate) {
        EntityManager em = emf.createEntityManager();
        JPAQueryFactory query = new JPAQueryFactory(em);

        QMovie qMovie = new QMovie("m");
        QParticipation qParticipation = new QParticipation("q");

        List<Movie> movies = query.selectFrom(qMovie)
                .join(qMovie.actors, qParticipation)
                .fetchJoin()
                .where(qMovie.director.eq(director)
                        .or(qParticipation.actor.eq(actor))
                        .or(qMovie.openDate.eq(openingDate)))
                .fetch();

        movies.forEach(m -> System.out.println(m.getInfo())
        );
    }

    public static void showMovieWithWorkerId(Long movieId) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();

            Movie findMovie = em.find(Movie.class, movieId);
            System.out.println(findMovie.getInfo());

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    public static void createMovieInfo() {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            Director director = new Director("토니", LocalDate.of(2020, 3, 20), "미국");
            Movie movie = new Movie("아이언맨", LocalDate.of(2020, 3, 20), Genre.Action, 40, director);
            Movie movie1 = new Movie("아이언맨2", LocalDate.of(2010, 3, 21), Genre.Action, 20, director);
            Actor actor = new Actor("배우", LocalDate.of(2020, 3, 10), 180, "@멋진배우");
            Participation attempt = new Participation(movie, actor, "주연");

            em.persist(movie);
            em.persist(movie1);
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
