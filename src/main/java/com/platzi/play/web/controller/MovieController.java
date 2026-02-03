package com.platzi.play.web.controller;

import com.platzi.play.domain.dto.MovieDTO;
import com.platzi.play.domain.dto.UpdateMovieDTO;
import com.platzi.play.domain.service.MovieService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies") // Ahora este será el path predeterminado
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }
    // Clase importada ResponseEntity para generar códigos HTTP y personalizar estos mismos.
    // Este método NO necesita ("/..") ya que usa el de @RequestMapping("/movies")
    @GetMapping
    // Devuelve un ResponseEntity, el cual tiene como parámetro una lista de MovieDTO
    public ResponseEntity<List<MovieDTO>> getAll(){
        return ResponseEntity.ok(this.movieService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovieDTO> getById(@PathVariable long id){
        MovieDTO movieDto = this.movieService.getById(id);

        if (movieDto == null){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(movieDto);
    }

    @PostMapping
    public ResponseEntity<MovieDTO> add(@RequestBody MovieDTO movieDto){
        MovieDTO movieDtoResponse = this.movieService.add(movieDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(movieDtoResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MovieDTO> update(@PathVariable Long id, @RequestBody UpdateMovieDTO updateMovieDto){
        return ResponseEntity.ok(this.movieService.update(id, updateMovieDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id){
        movieService.deleteById(id);
        return ResponseEntity.ok("La Movie con ID " + id + " ha sido eliminada correctamente");
    }
}
