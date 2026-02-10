package com.platzi.play.domain.exception;

public class MovieNotExistsException extends RuntimeException {
    public MovieNotExistsException(long id) {
        super("La pelicula con el id " + id + " no existe.");
    }
}
