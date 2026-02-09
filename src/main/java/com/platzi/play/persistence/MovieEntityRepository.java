package com.platzi.play.persistence;

import com.platzi.play.domain.dto.UpdateMovieDTO;
import com.platzi.play.domain.repository.MovieRepository;
import com.platzi.play.domain.dto.MovieDTO;
import com.platzi.play.persistence.crud.CrudMovieEntity;
import com.platzi.play.persistence.entity.MovieEntity;
import com.platzi.play.persistence.mapper.MovieMapper;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
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
        return this.movieMapper.toDto(this.crudMovieEntity.findAll());
    }

    @Override
    public MovieDTO getById(long id){
        MovieEntity movieEntity = this.crudMovieEntity.findById(id).orElse(null);
        return this.movieMapper.toDto(movieEntity); // Mapear para retornar un DTO y no un MovieEntity
    }

    @Override
    public MovieDTO save(MovieDTO movieDto) {
        MovieEntity movieEntity = this.movieMapper.toEntity(movieDto);
        movieEntity.setEstado("D");

        return this.movieMapper.toDto(this.crudMovieEntity.save(movieEntity));
    }

    @Override
    public MovieDTO update(long id, UpdateMovieDTO updateMovieDto) {
        // Primero busca la movie por su id, comprobando su existencia o no.
        MovieEntity movieEntity = this.crudMovieEntity.findById(id).orElse(null);

        if (movieEntity == null) return null;

        /* Asignar los nuevos valores a los parámetros con nuestro método updateEntityFromDto
        desde el MovieMapper*/
        this.movieMapper.updateEntityFromDto(updateMovieDto, movieEntity);


        /* Asignar nuevos valores a los parámetros (uno por uno)
        movieEntity.setTitulo(updateMovieDto.title());
        movieEntity.setFechaEstreno(updateMovieDto.releaseDate());
        movieEntity.setClasificacion(BigDecimal.valueOf(updateMovieDto.rating()));*/

        return this.movieMapper.toDto(crudMovieEntity.save(movieEntity));
    }

    @Override
    public void deleteById(long id) {
        this.crudMovieEntity.deleteById(id);
    }
}
