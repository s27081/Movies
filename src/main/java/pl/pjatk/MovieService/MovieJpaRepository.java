package pl.pjatk.MovieService;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface MovieJpaRepository extends JpaRepository<Movie, Integer> {
    @Query("SELECT m FROM Movie m")
    List<Movie> getAllMovies();

    @Query("SELECT m FROM Movie m WHERE m.id = :id")
    Movie findMovieById(@Param("id") Integer id);

}
