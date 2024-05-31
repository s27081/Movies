package pl.pjatk.MovieService;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface MovieJpaRepository extends JpaRepository<Movie, Integer> {
    List<Movie> getAllMovies();
    Movie findMovieById(Integer id);
    void addMovie(Movie movie);
    void deleteMovieById(Integer id);
}
