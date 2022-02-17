package com.kata.cinema.base.webapp.controllers.user;

import com.kata.cinema.base.models.dto.WatchlistDto;
import com.kata.cinema.base.models.entity.Movie;
import com.kata.cinema.base.models.entity.Watchlist;
import com.kata.cinema.base.service.abstracts.dto.WatchlistDtoService;
import com.kata.cinema.base.service.abstracts.entity.MovieService;
import com.kata.cinema.base.service.abstracts.entity.WatchlistService;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Positive;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/user/watchlist")
@Validated
@AllArgsConstructor
public class UserWatchlistRestController {
    private final WatchlistDtoService watchlistDtoService;
    private final MovieService movieService;
    private final WatchlistService watchlistService;

    @ApiOperation(value = "получить список Watchlist", notes = "получить список пользователей Watchlist", responseContainer = "list", response = WatchlistDto.class)
    @GetMapping
    public ResponseEntity<List<WatchlistDto>> getWatchlistByUserId(@Positive @RequestParam Long userId) {
        return ResponseEntity.ok(watchlistDtoService.findAllWatchlistByUserId(userId));
    }

    @ApiOperation(value = "получить Watchlist по id", notes = "получить Watchlist по id", response = WatchlistDto.class)
    @GetMapping("/{id}")
    public ResponseEntity<WatchlistDto> getWatchlistById(@Positive @PathVariable("id") Long id) {
        return ResponseEntity.ok(watchlistDtoService.findWatchlistDtoById(id).get());
    }

    @PostMapping("/{id}/movies")
    public ResponseEntity<HttpStatus> addMovieToWatchlist(@RequestBody List<Long> moviesId,
                                                         @PathVariable("id") Long id) {
        Watchlist watchlist = watchlistService.getById(id).get();
        Set<Movie> movies = watchlist.getMovies();

        movieService.getListOfMoviesById(moviesId).stream().collect(Collectors.toCollection(() -> movies));

        watchlistService.update(watchlist);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}/movies")
    public ResponseEntity<HttpStatus> deleteMovieFromWatchlist(@RequestBody List<Long> moviesId,
                                                              @PathVariable("id") Long id) {
        Watchlist watchlist = watchlistService.getById(id).get();
        Set<Movie> movies = watchlist.getMovies();

        Set<Movie> movieSet = new HashSet<>(movieService.getListOfMoviesById(moviesId));

        movies.removeAll(movieSet);
        watchlistService.update(watchlist);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
