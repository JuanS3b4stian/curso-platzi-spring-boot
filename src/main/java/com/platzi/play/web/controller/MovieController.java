package com.platzi.play.web.controller;

import com.platzi.play.persistence.crud.CrudMovieEntity;
import com.platzi.play.persistence.entity.MovieEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MovieController {

    private final CrudMovieEntity crudMovieEntity;

    // Podemos usar @AutoWired, pero lo más recomendado es inyectar la dependencia con el constructor
    public MovieController(CrudMovieEntity crudMovieEntity) {
        this.crudMovieEntity = crudMovieEntity;
    }

    @GetMapping("/movies")
    public List<MovieEntity> getAll(){
        return (List<MovieEntity>) this.crudMovieEntity.findAll();
    }
}
