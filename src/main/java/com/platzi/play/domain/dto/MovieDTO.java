package com.platzi.play.domain.dto;

import com.platzi.play.domain.Gender;

import java.time.LocalDate;

public record MovieDTO(
        Long id, // No se añade al MovieMapper, mapStruct toma las variables con el mismo nombre y las convierte.
        String title,
        Integer duration,
        Gender gender,
        LocalDate releaseDate,
        Double rating
) {
}
