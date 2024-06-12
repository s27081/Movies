package pl.pjatk.MovieService;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    private final MovieJpaRepository movieJpaRepository;

    public MovieService(MovieJpaRepository movieJpaRepository) {
        this.movieJpaRepository = movieJpaRepository;
    }

    public List<Movie> getMovieList() throws MovieNotFoundException {
        if (movieJpaRepository.findAll().isEmpty()) {
            throw new MovieNotFoundException("Movie list unavailable");
        }
        return movieJpaRepository.getAllMovies();
    }

    public Movie getMovieByID(Integer id) throws MovieNotFoundException {
        Movie movie = movieJpaRepository.findMovieById(id);
        if (movie == null) {
            throw new MovieNotFoundException("Movie not found with ID: " + id);
        }
        return movieJpaRepository.findMovieById(id);

    }
    public void addMovie(Movie movie) throws MovieBadRequestException {
        if (movie == null || movie.getName() == null || movie.getName().isEmpty()) {
            throw new MovieBadRequestException("Invalid movie data provided");
        }
        movieJpaRepository.save(movie);
    }

    public void deleteMovie(Integer id) throws MovieNotFoundException {
        if (!movieJpaRepository.existsById(id)) {
            throw new MovieNotFoundException("Movie not found with ID: " + id);
        }
        movieJpaRepository.deleteById(id);
    }
}