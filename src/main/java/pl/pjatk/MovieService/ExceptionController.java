package pl.pjatk.MovieService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;

@RestControllerAdvice
public class ExceptionController {

    @ExceptionHandler(MovieNotFoundException.class)
    public ResponseEntity<String> handleNotFoundException(MovieNotFoundException movieNotFoundException){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Movie not found");
    }

    @ExceptionHandler(MovieBadRequestException.class)
    public ResponseEntity<String> handleBadRequestException(MovieBadRequestException movieBadRequestException){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error ID added to body");
    }
}
