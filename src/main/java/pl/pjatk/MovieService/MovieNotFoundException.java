package pl.pjatk.MovieService;


public class MovieNotFoundException extends Exception {
    public MovieNotFoundException(String errorMsg){
        super(errorMsg);
    }
}
