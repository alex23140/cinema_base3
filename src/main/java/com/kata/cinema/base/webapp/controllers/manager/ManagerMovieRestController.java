package com.kata.cinema.base.webapp.controllers.manager;

import com.kata.cinema.base.mapper.MovieMapper;
import com.kata.cinema.base.models.dto.MovieDto;
import com.kata.cinema.base.models.entity.Movie;
import com.kata.cinema.base.service.abstracts.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/manager")
public class ManagerMovieRestController {

    private final MovieService movieService;
    private final MovieMapper movieMapper;

    @Autowired
    public ManagerMovieRestController(MovieService movieService, MovieMapper movieMapper) {
        this.movieService = movieService;
        this.movieMapper = movieMapper;
    }

    @PostMapping("/movie")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveMovie(@RequestBody MovieDto movie) {
        movieService.create(movieMapper.toEntity(movie));
    }

    @GetMapping("/movie/{id}")
    public MovieDto getMovie(@PathVariable("id") long id) {
        return null;
    }
}
