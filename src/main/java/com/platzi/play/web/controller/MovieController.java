package com.platzi.play.web.controller;

import com.platzi.play.domain.dto.MovieDTO;
import com.platzi.play.domain.service.MovieService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/movies") // Ahora este será el path predeterminado
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    // Este método NO necesita ("/..") ya que usa el de @RequestMapping("/movies")
    @GetMapping
    public List<MovieDTO> getAll(){
        return this.movieService.getAll();
    }

    @GetMapping("/{id}")
    public MovieDTO getById(@PathVariable long id){
        return this.movieService.getById(id); // Controlador llama al Service
    }
}
