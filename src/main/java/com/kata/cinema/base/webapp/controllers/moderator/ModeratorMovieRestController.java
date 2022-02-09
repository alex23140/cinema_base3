package com.kata.cinema.base.webapp.controllers.moderator;

import com.kata.cinema.base.mapper.MovieMapper;
import com.kata.cinema.base.models.dto.MovieDto;
import com.kata.cinema.base.models.entity.Movie;
import com.kata.cinema.base.service.abstracts.dto.MovieDtoService;
import com.kata.cinema.base.service.abstracts.entity.MovieService;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;

@RestController
@RequestMapping("/api/moderator/movie")
@Validated
@AllArgsConstructor
public class ModeratorMovieRestController {
    private final MovieDtoService movieDtoService;
    private final MovieService movieService;
    private final MovieMapper movieMapper;

    @ApiOperation(value = "Создание Movie", notes = "Создание Movie")
    @PostMapping
    public ResponseEntity<MovieDto> saveMovie(@Valid @RequestBody MovieDto movieDto) {
        Movie movie = movieMapper.toEntity(movieDto);
        movieService.create(movie);
        return ResponseEntity.status(HttpStatus.CREATED).body(movieMapper.toDto(movie));
    }

    @ApiOperation(value = "Получение Movie по id", notes = "Получение Movie по id")
    @GetMapping("/{id}")
    public ResponseEntity<MovieDto> getMovie(@Positive @PathVariable("id") Long id) {
        return ResponseEntity.ok().body(movieDtoService.getById(id));
    }
}
