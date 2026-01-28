package com.platzi.play.persistence.mapper;

import com.platzi.play.persistence.entity.MovieEntity;
import com.platzi.play.domain.dto.MovieDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MovieMapper {

    @Mapping(source = "titulo", target = "title")
    @Mapping(source = "duracion", target = "duration")
    @Mapping(source = "genero", target = "gender")
    @Mapping(source = "fechaEstreno", target = "releaseDate")
    @Mapping(source = "clasificacion", target = "rating")
    MovieDTO toDTO(MovieEntity entity);
    List<MovieDTO> toDTO(Iterable<MovieEntity> entities);
}
