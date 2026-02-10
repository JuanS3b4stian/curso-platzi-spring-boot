package com.platzi.play.web.exception;

import com.platzi.play.domain.exception.MovieAlreadyExistsException;
import com.platzi.play.domain.exception.MovieNotExistsException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

// Clase encargada de capturar las excepciones que ocurran dentro de la aplicación
@RestControllerAdvice
public class RestExceptionHandler {
    @ExceptionHandler(MovieAlreadyExistsException.class)
    public ResponseEntity<Error> handleException(MovieAlreadyExistsException ex){
        Error error = new Error("movie-already-exists", ex.getMessage());
        return ResponseEntity.badRequest().body(error);
    }

    @ExceptionHandler(MovieNotExistsException.class)
    public ResponseEntity<Error> handleException(MovieNotExistsException ex){
        Error error = new Error("movie-does-not-exist", ex.getMessage());
        return ResponseEntity.badRequest().body(error);
    }
}
