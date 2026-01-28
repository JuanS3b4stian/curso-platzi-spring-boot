package com.platzi.play.domain.service;

import com.platzi.play.domain.dto.MovieDTO;
import com.platzi.play.domain.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<MovieDTO> getAll(){
        return this.movieRepository.getAll();
    }

    public MovieDTO getById(long id){
        return this.movieRepository.getById(id); // Service llama a Repository
    }
}
