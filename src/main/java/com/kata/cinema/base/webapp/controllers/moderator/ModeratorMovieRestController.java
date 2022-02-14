package com.kata.cinema.base.webapp.controllers.moderator;


import com.kata.cinema.base.dao.abstracts.model.MovieDao;
import com.kata.cinema.base.mapper.MovieMapper;
import com.kata.cinema.base.models.dto.MovieDto;
import com.kata.cinema.base.models.entity.Movie;
import com.kata.cinema.base.service.abstracts.dto.MovieDtoService;
import com.kata.cinema.base.service.abstracts.entity.MovieService;
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
    private final MovieDao movieDao;

    @PostMapping
    public ResponseEntity<MovieDto> saveMovie(@Valid @RequestBody MovieDto movieDto) {
        Movie movie = movieMapper.toEntity(movieDto);
        movieService.create(movie);
        return ResponseEntity.status(HttpStatus.CREATED).body(movieMapper.toDto(movie));
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovieDto> getMovie(@Positive @PathVariable("id") Long id) {
        return ResponseEntity.ok().body(movieDtoService.getById(id));
    }

    @PostMapping("{id}/uploadPreview")
     public ResponseEntity<MovieDto> upload(@PathVariable("id") Long id,
                                           @RequestParam("file") MultipartFile file) {

        if (!movieDao.isExistById(id)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(movieMapper.toDto(new Movie() ));
        }
        if (file.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(movieMapper.toDto(new Movie() ));
        }

        try {
            if (movieService.MovieUploadPreview(id, file)) {

                Optional<Movie> movie = movieDao.getById(id);
                movie.get().setPreviewIsExist(true);
                movieDao.update(movie.get());

                // сохранили изображение и изменили PreviewIsExist
                 return ResponseEntity.status(HttpStatus.CREATED).body(movieMapper.toDto(movie.get()));
            }else{
                // случай когда
                // 1 ошибка при сохранении
                // 2 недопустимый файл
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(movieMapper.toDto(new Movie() ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        return null;
    }
}
