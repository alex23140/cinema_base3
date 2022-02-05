package com.kata.cinema.base.webapp.controllers.user;


import com.kata.cinema.base.models.dto.WatchlistDto;
import com.kata.cinema.base.service.impl.WatchlistDtoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user/watchlist")
public class WatchlistController {


    private final WatchlistDtoServiceImpl watchlistDtoService;

    @Autowired
    public WatchlistController(WatchlistDtoServiceImpl watchlistDtoService) {
        this.watchlistDtoService = watchlistDtoService;
    }

    @GetMapping
    public ResponseEntity<List<WatchlistDto>> getWatchlistByUserId(@RequestParam Long userId) {
        return ResponseEntity.ok(watchlistDtoService.findAllWatchlistByUserId(userId));
    }


    @GetMapping("/{id}")
    public ResponseEntity<WatchlistDto> getWatсhlistById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(watchlistDtoService.findWatchlistDtoById(id));
    }

}
