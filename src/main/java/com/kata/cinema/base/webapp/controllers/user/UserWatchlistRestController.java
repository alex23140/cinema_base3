package com.kata.cinema.base.webapp.controllers.user;

import com.kata.cinema.base.mapper.WatchlistMapper;
import com.kata.cinema.base.models.dto.WatchlistDto;
import com.kata.cinema.base.models.entity.Movie;
import com.kata.cinema.base.models.entity.Watchlist;
import com.kata.cinema.base.models.enums.Category;
import com.kata.cinema.base.service.abstracts.dto.WatchlistDtoService;
import com.kata.cinema.base.service.abstracts.entity.MovieService;
import com.kata.cinema.base.service.abstracts.entity.WatchlistService;
import com.kata.cinema.base.webapp.util.ApiValidationUtils;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/api/user/watchlist")
@Validated
@AllArgsConstructor
public class UserWatchlistRestController {
    private final WatchlistDtoService watchlistDtoService;
    private final MovieService movieService;
    private final WatchlistService watchlistService;
    private final WatchlistMapper watchlistMapper;


    @ApiOperation(value = "получить список Watchlist", notes = "получить список пользователей Watchlist", responseContainer = "list", response = WatchlistDto.class)
    @GetMapping
    public ResponseEntity<List<WatchlistDto>> getWatchlistByUserId(@Positive @RequestParam Long userId) {
        return ResponseEntity.ok(watchlistDtoService.findAllWatchlistByUserId(userId));
    }

    @ApiOperation(value = "получить Watchlist по id", notes = "получить Watchlist по id", response = WatchlistDto.class)
    @GetMapping("/{id}")
    public ResponseEntity<WatchlistDto> getWatchlistById(@Positive @PathVariable("id") Long id) {
        Optional<WatchlistDto> watchlistDto = watchlistDtoService.findWatchlistDtoById(id);
        ApiValidationUtils.requireTrue(watchlistDto.isPresent(), "списка с указанным id не существует");
        return ResponseEntity.ok(watchlistDto.get());
    }

    @ApiOperation(value = "добавить фильмы в список", notes = "добавить фильмы в список Watchlist", response = HttpStatus.class)
    @PostMapping("/{id}/movies")
    public ResponseEntity<HttpStatus> addMovieToWatchlist(@RequestBody List<Long> moviesId,
                                                          @Positive @PathVariable("id") Long id) {
        Optional<Watchlist> watchlist = watchlistService.getWatchListById(id);
        ApiValidationUtils.requireTrue(watchlist.isPresent(), "списка с указанным id не существует");
        Watchlist watchlist1 = watchlist.get();
        Set<Movie> movies = watchlist1.getMovies();
        movies.addAll(movieService.getListOfMoviesById(moviesId));
        watchlistService.update(watchlist1);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @ApiOperation(value = "удалить фильмы из списка", notes = "удалить фильмы из Watchlist", response = HttpStatus.class)
    @DeleteMapping("/{id}/movies")
    public ResponseEntity<HttpStatus> deleteMovieFromWatchlist(@RequestBody List<Long> moviesId,
                                                               @Positive @PathVariable("id") Long id) {
        Optional<Watchlist> optionalWatchlist = watchlistService.getWatchListById(id);
        ApiValidationUtils.requireTrue(optionalWatchlist.isPresent(), "списка с указанным id не существует");
        Watchlist watchlist = optionalWatchlist.get();
        Set<Movie> movies = watchlist.getMovies();
        Set<Movie> movieSet = new HashSet<>(movieService.getListOfMoviesById(moviesId));
        movies.removeAll(movieSet);
        watchlistService.update(watchlist);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<WatchlistDto> editWatchlist(@Valid @RequestBody WatchlistDto watchlistDto) {

        if (Category.CUSTOM.equals(watchlistDto.getCategory()) && (!watchlistDto.getName().equals(""))) {
            Watchlist watchlist = watchlistMapper.toEntity(watchlistDto);
            watchlistService.update(watchlist);
            return ResponseEntity.status(HttpStatus.OK).body(watchlistMapper.toDto(watchlist));
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(watchlistDto);
        }
    }

    @PostMapping
    public ResponseEntity<WatchlistDto> saveWatchlist(@Valid @RequestBody WatchlistDto watchlistDto) {

        if (Category.CUSTOM.equals(watchlistDto.getCategory()) && (!watchlistDto.getName().equals(""))) {
            Watchlist watchlist = watchlistMapper.toEntity(watchlistDto);
            watchlistService.create(watchlist);
            return ResponseEntity.status(HttpStatus.CREATED).body(watchlistMapper.toDto(watchlist));
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(watchlistDto);
        }
    }
}
