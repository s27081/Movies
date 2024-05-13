package pl.pjatk.MovieService;


public class MovieBadRequestException extends Exception{
    public MovieBadRequestException(String errorMsg){
        super(errorMsg);
    }
}
