package com.platzi.play.domain.repository;

import com.platzi.play.domain.dto.MovieDTO;

import java.util.List;

public interface MovieRepository {
    List<MovieDTO> getAll();
    // Repository retorna un movieDTO y llama al MovieEntityRepository que verifica la petición en el CRUD interno
    MovieDTO getById(long id);
    MovieDTO save(MovieDTO movieDto);
}
