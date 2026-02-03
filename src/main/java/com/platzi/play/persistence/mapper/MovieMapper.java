package com.platzi.play.persistence.mapper;

import com.platzi.play.domain.dto.MovieDTO;
import com.platzi.play.domain.dto.UpdateMovieDTO;
import com.platzi.play.persistence.entity.MovieEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring", uses = {GenderMapper.class})
public interface MovieMapper {
    @Mapping(source = "titulo", target = "title")
    @Mapping(source = "duracion", target = "duration")
    @Mapping(source = "genero", target = "gender", qualifiedByName = "stringToGender")
    @Mapping(source = "fechaEstreno", target = "releaseDate")
    @Mapping(source = "clasificacion", target = "rating")

    MovieDTO toDto(MovieEntity entity);
    List<MovieDTO> toDto(Iterable<MovieEntity> entities);

    @InheritInverseConfiguration
    @Mapping(source = "gender", target = "genero", qualifiedByName = "genderToString")
    MovieEntity toEntity(MovieDTO dto);

    @Mapping(target = "titulo", source = "title")
    @Mapping(target = "fechaEstreno", source = "releaseDate")
    @Mapping(target = "clasificacion", source = "rating")
    void updateEntityFromDto(UpdateMovieDTO updateMovieDto, @MappingTarget MovieEntity movieEntity);
}