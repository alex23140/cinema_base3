package com.kata.cinema.base.webapp.controllers.moderator;


import com.kata.cinema.base.dao.abstracts.model.MovieDao;
import com.kata.cinema.base.mapper.MovieMapper;
import com.kata.cinema.base.models.dto.MovieDto;
import com.kata.cinema.base.models.dto.MoviePersonDto;
import com.kata.cinema.base.models.entity.Movie;
import com.kata.cinema.base.service.abstracts.dto.MovieDtoService;
import com.kata.cinema.base.service.abstracts.entity.MovieService;
import com.kata.cinema.base.webapp.util.ApiValidationUtils;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.util.Optional;

@RestController
@RequestMapping("/api/moderator/movie")
@Validated
@AllArgsConstructor
public class ModeratorMovieRestController {
    private final MovieDtoService movieDtoService;
    private final MovieService movieService;
    private final MovieMapper movieMapper;

    //TODO проверить сохранение жанров
    @ApiOperation(value = "Создание Movie", notes = "Создание Movie", response = MovieDto.class)
    @PostMapping
    public ResponseEntity<MovieDto> saveMovie(@Valid @RequestBody MovieDto movieDto) {
        Movie movie = movieMapper.toEntity(movieDto);
        movieService.create(movie);
        return ResponseEntity.status(HttpStatus.CREATED).body(movieMapper.toDto(movie));
    }

    //TODO здесь отрефакторить под MoviePersonDto
    @ApiOperation(value = "Получение Movie по id", notes = "Получение Movie по id", response = MovieDto.class)
    @GetMapping("/{id}")
    public ResponseEntity<MoviePersonDto> getMovie(@Positive @PathVariable("id") Long id) {
        MoviePersonDto moviePersonDto = movieDtoService.getById(id).get();

        return ResponseEntity.ok().body(movieDtoService.getById(id).get());
    }

    @PostMapping("/{id}/uploadPreview")
     public ResponseEntity<?> uploadPreview(@PathVariable("id") Long id,
                                            @RequestParam("file") MultipartFile file) {
        Optional<Movie> movieOptional = movieService.getById(id);
        ApiValidationUtils.requireTrue(movieOptional.isPresent(), "фильма с таким id не существует");
        ApiValidationUtils.requireFalse(file.isEmpty(), "пришел пустой файл");

        movieService.movieUploadPreview(id, file);
        Movie movie = movieOptional.get();
        movie.setPreviewIsExist(true);
        movieService.update(movie);
        return ResponseEntity.ok("превью добавлено");
    }
}
