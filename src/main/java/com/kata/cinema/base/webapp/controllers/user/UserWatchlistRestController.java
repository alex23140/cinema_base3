package com.kata.cinema.base.webapp.controllers.user;


import com.kata.cinema.base.models.dto.WatchlistDto;
import com.kata.cinema.base.service.abstracts.WatchlistDtoService;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Positive;
import java.util.List;

@RestController
@RequestMapping("/api/user/watchlist")
@Validated
@AllArgsConstructor
public class UserWatchlistRestController {
    private final WatchlistDtoService watchlistDtoService;

    @ApiOperation(value = "получить список Watchlist", notes = "получить список пользователей Watchlist")
    @GetMapping
    public ResponseEntity<List<WatchlistDto>> getWatchlistByUserId(@Positive @RequestParam Long userId) {
        return ResponseEntity.ok(watchlistDtoService.findAllWatchlistByUserId(userId));
    }

    @ApiOperation(value = "получить Watchlist по id", notes = "получить Watchlist по id")
    @GetMapping("/{id}")
    public ResponseEntity<WatchlistDto> getWatchlistById(@Positive @PathVariable("id") Long id) {
        return ResponseEntity.ok(watchlistDtoService.findWatchlistDtoById(id));
    }

}
