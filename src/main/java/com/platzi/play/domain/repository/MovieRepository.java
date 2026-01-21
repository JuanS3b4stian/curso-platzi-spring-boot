package com.platzi.play.domain.repository;

import com.platzi.play.domain.dto.MovieDTO;

import java.util.List;

public interface MovieRepository {
    List<MovieDTO> getAll();
}
