package com.platzi.play.domain.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;

import java.time.LocalDate;

public record UpdateMovieDTO(
        @NotBlank(message = "El título es obligatorio")
        String title,

        @PastOrPresent(message = "La fecha de lanzamiento debe ser anterior a la fecha actual")
        LocalDate releaseDate,

        @Min(value = 0, message = "El rating debe de ser mayor de 0")
        @Max(value = 5, message = "El rating no puede ser mayor que 5")
        Double rating
) {
}
