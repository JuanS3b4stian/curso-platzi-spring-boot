package com.platzi.play.domain.dto;

import java.time.LocalDate;

public record UpdateMovieDTO(
        String title,
        LocalDate releaseDate,
        Double rating
) {
}
