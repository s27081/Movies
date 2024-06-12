package pl.pjatk.MovieService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/moviesApp")
public class MovieController {

    private final MovieService movieService;


    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/movies")
    public ResponseEntity<List<Movie>> movieList() throws MovieNotFoundException {
        try {
            return ResponseEntity.ok(movieService.getMovieList());
        } catch (MovieNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/movies/{id}")
    public ResponseEntity<?> singleMovie(@PathVariable("id") Integer movieId) throws MovieNotFoundException {
        try {
            return ResponseEntity.ok(movieService.getMovieByID(movieId));
        } catch (MovieNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PostMapping("/movies")
    public ResponseEntity<?> postMovie(@RequestBody Movie movie) {
        try {
            movieService.addMovie(movie);
            return ResponseEntity.ok(movie);
        } catch (MovieBadRequestException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PutMapping("/movies/{id}")
    public ResponseEntity<?> updateMovie(@PathVariable Integer id, @RequestBody Movie movie) throws MovieBadRequestException {
        try {
            Movie updatedMovie = movieService.getMovieByID(id);
            updatedMovie.setId(movie.getId());
            updatedMovie.setName(movie.getName());
            updatedMovie.setMovieCategory(movie.getMovieCategory());
            updatedMovie.setYearProduction(movie.getYearProduction());
            movieService.addMovie(updatedMovie);
            return ResponseEntity.ok(updatedMovie);
        } catch (MovieNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @DeleteMapping("/movies/{id}")
    public ResponseEntity<?> deleteMovie(@PathVariable Integer id) throws MovieNotFoundException {
        try {
            movieService.deleteMovie(id);
        } catch (MovieNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
        return ResponseEntity.ok().build();
    }

    @PutMapping("/movies/bool/{isAvailable}/{id}")
    public ResponseEntity<?> updateIsAvailable(@PathVariable Integer id, @PathVariable Boolean isAvailable) throws MovieBadRequestException {
        try {
            Movie updatedIsAvailable = movieService.getMovieByID(id);
            updatedIsAvailable.setAvailable(isAvailable);
            movieService.addMovie(updatedIsAvailable);
            return ResponseEntity.ok(updatedIsAvailable);
        } catch (MovieNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

}
