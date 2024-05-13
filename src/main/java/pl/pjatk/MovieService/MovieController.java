package pl.pjatk.MovieService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/moviesApp")
public class MovieController {

    private final MovieService movieService;


    public MovieController(MovieService movieService){
        this.movieService = movieService;
    }

    @GetMapping("/movies")
    public ResponseEntity<List<Movie>> movieList(){
        return ResponseEntity.ok(movieService.getMovieList());
    }

    @GetMapping("/movies/{id}")
    public ResponseEntity<Movie> singleMovie(@PathVariable("id") Integer movieId) throws MovieNotFoundException{
        return ResponseEntity.ok(movieService.getMovieByID(movieId));
    }

    @PostMapping("/movies")
    public ResponseEntity<Movie> postMovie(@RequestBody Movie movie) throws MovieBadRequestException{
        movieService.addMovie(movie);
        return ResponseEntity.ok(movie);
    }

    @PutMapping("/movies/{id}")
    public ResponseEntity<Movie> updateMovie(@PathVariable Integer id, @RequestBody Movie movie) throws MovieNotFoundException {
        Movie updatedMovie = movieService.getMovieByID(id);
        updatedMovie.setId(movie.getId());
        updatedMovie.setName(movie.getName());
        updatedMovie.setMovieCategory(movie.getMovieCategory());
        updatedMovie.setYearProduction(movie.getYearProduction());
        return ResponseEntity.ok(updatedMovie);
    }

    @DeleteMapping("/movies/{id}")
    public ResponseEntity<Void> deleteMovie(@PathVariable Integer id) throws  MovieNotFoundException{
        movieService.deleteMovie(id);
        return ResponseEntity.ok().build();
    }
}
