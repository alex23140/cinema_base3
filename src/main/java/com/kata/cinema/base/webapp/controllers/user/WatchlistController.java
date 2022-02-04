package com.kata.cinema.base.webapp.controllers.user;


import com.kata.cinema.base.models.dto.WatchlistDto;
import com.kata.cinema.base.service.impl.WatchlistDtoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class WatchlistController {


    private final WatchlistDtoServiceImpl watchlistDtoService;

    @Autowired
    public WatchlistController(WatchlistDtoServiceImpl watchlistDtoService) {
        this.watchlistDtoService = watchlistDtoService;
    }

    @GetMapping("/api/user/watchlist")
    public List<WatchlistDto> getWatchlistByUserId( @RequestParam Long userId) {
        return watchlistDtoService.findAllWatchlistByUserId(userId);
    }


    @GetMapping("/api/user/watchlist/{id}")
    public WatchlistDto getWatсhlistById (@PathVariable Long id) {
        return watchlistDtoService.findWatchlistDtoById(id);
    }


}
