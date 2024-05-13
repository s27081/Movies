package pl.pjatk.MovieService;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class MovieService {

    private List<Movie> movieList;

    private Movie movie1 = new Movie(0, "Batman", MovieCategory.Action, 2012);
    private Movie movie2 = new Movie(1, "Obecność", MovieCategory.Horror, 2016);
    private Movie movie3 = new Movie(2, "Fallout", MovieCategory.SciFi, 2024);

    public MovieService(List<Movie> movieList) {
        this.movieList = movieList;
        movieList.add(movie1);
        movieList.add(movie2);
        movieList.add(movie3);

    }

    public List<Movie> getMovieList() {
        return movieList;
    }

    public void setMovieList(List<Movie> movieList) {
        this.movieList = movieList;
    }

    public Movie getMovieByID(Integer id) throws MovieNotFoundException {
        for (Movie movie : getMovieList()) {
            if (Objects.equals(movie.getId(), id)) {
                return movie;
            }
        }
        throw new MovieNotFoundException("Movie not found");
    }

    public void addMovie(Movie movie) throws MovieBadRequestException {
        if (movie.getId() != null) {
            throw new MovieBadRequestException("ID provided");
        }
        movieList.add(movie);
        System.out.println(movie.getName());
    }

    public void deleteMovie(Integer id) throws MovieNotFoundException {
        for (Movie movie : getMovieList()) {
            if (Objects.equals(movie.getId(), id)) {
                movieList.remove(movie);
            }
        }
        throw new MovieNotFoundException("Movie not found");
    }
}