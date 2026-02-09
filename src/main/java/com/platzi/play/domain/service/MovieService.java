package com.platzi.play.domain.service;

import com.platzi.play.domain.dto.MovieDTO;
import com.platzi.play.domain.dto.UpdateMovieDTO;
import com.platzi.play.domain.repository.MovieRepository;
import dev.langchain4j.agent.tool.Tool;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    // @Tool normalmente viene en todos los LLMs
    // Ahora que anotamos con @Tool, LangChain4j sabrá cómo y cuándo usar este método (servicio)
    @Tool("Busca todas las películas que existan dentro de la plataforma")
    public List<MovieDTO> getAll(){
        return this.movieRepository.getAll();
    }

    public MovieDTO getById(long id){
        return this.movieRepository.getById(id); // Service llama a Repository
    }

    public MovieDTO add(MovieDTO movieDto) {
        return this.movieRepository.save(movieDto);
    }

    public MovieDTO update(long id, UpdateMovieDTO updateMovieDTO){
        return this.movieRepository.update(id, updateMovieDTO);
    }

    public void deleteById(long id){
        this.movieRepository.deleteById(id);
    }

}
