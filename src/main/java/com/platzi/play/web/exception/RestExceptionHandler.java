package com.platzi.play.web.exception;

import com.platzi.play.domain.exception.MovieAlreadyExistsException;
import com.platzi.play.domain.exception.MovieNotExistsException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

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


    // Manejo de errores con ExceptionHandler que devuelve una Lista de Errors
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<Error>> handleException(MethodArgumentNotValidException ex){
        List<Error> errors = new ArrayList<>();

        ex.getBindingResult().getFieldErrors().forEach((error)->{
            // Manda el campo y el mensaje personalizado que tiene cada parámetro
            errors.add(new Error(error.getField(), error.getDefaultMessage()));
        });

        return ResponseEntity.badRequest().body(errors);
    }

    // Exception.class es la clase encargada para validar las excepciones generales
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Error> handleException(Exception ex){
        Error error = new Error("unknow-error", ex.getMessage());
        return ResponseEntity.internalServerError().body(error);
    }
}
