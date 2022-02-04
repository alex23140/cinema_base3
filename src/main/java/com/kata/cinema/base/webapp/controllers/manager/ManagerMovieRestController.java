package com.kata.cinema.base.webapp.controllers.manager;

import com.kata.cinema.base.mapper.MovieMapper;
import com.kata.cinema.base.models.dto.MovieDto;
import com.kata.cinema.base.models.entity.Movie;
import com.kata.cinema.base.service.abstracts.dto.MovieDtoService;
import com.kata.cinema.base.service.abstracts.entity.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;

@RestController
@RequestMapping("/api/manager/movie")
@Validated
public class ManagerMovieRestController {
    private final MovieDtoService movieDtoService;
    private final MovieService movieService;
    private final MovieMapper movieMapper;

    @Autowired
    public ManagerMovieRestController(MovieDtoService movieDtoService, MovieService movieService, MovieMapper movieMapper) {
        this.movieDtoService = movieDtoService;
        this.movieService = movieService;
        this.movieMapper = movieMapper;
    }

    @PostMapping
    public ResponseEntity<?> saveMovie(@Valid @RequestBody MovieDto movie) {
        Movie movieDto = movieMapper.toEntity(movie);
        movieService.create(movieDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(movieDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovieDto> getMovie(@Positive @PathVariable("id") Long id) {
        return ResponseEntity.ok().body(movieDtoService.getById(id));
    }
}
