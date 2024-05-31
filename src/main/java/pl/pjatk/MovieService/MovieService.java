package pl.pjatk.MovieService;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    private final MovieJpaRepository movieJpaRepository;

    public MovieService(MovieJpaRepository movieJpaRepository) {
        this.movieJpaRepository = movieJpaRepository;
    }

    public List<Movie> getMovieList() {
        return movieJpaRepository.getAllMovies();
    }


    public Movie getMovieByID(Integer id) {
        return movieJpaRepository.findMovieById(id);

    }

    public void addMovie(Movie movie) {
        movieJpaRepository.addMovie(movie);
    }

    public void deleteMovie(Integer id) {
        movieJpaRepository.deleteMovieById(id);

    }
}