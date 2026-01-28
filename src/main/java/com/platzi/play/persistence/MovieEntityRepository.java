package com.platzi.play.persistence;

import com.platzi.play.domain.repository.MovieRepository;
import com.platzi.play.domain.dto.MovieDTO;
import com.platzi.play.persistence.crud.CrudMovieEntity;
import com.platzi.play.persistence.entity.MovieEntity;
import com.platzi.play.persistence.mapper.MovieMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MovieEntityRepository implements MovieRepository {

    // Inyección de las interfaces
    private final CrudMovieEntity crudMovieEntity;
    private final MovieMapper movieMapper;

    // Constructor para la inyección de interfaces
    public MovieEntityRepository(CrudMovieEntity crudMovieEntity, MovieMapper movieMapper) {
        this.crudMovieEntity = crudMovieEntity;
        this.movieMapper = movieMapper;
    }

    @Override
    public List<MovieDTO> getAll(){
        return this.movieMapper.toDTO(this.crudMovieEntity.findAll());
    }

    @Override
    public MovieDTO getById(long id){
        MovieEntity movieEntity = this.crudMovieEntity.findById(id).orElse(null);
        return this.movieMapper.toDTO(movieEntity); // Mapear para retornar un DTO y no un MovieEntity
    }
}
