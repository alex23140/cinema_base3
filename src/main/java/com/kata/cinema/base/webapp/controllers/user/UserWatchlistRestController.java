package com.kata.cinema.base.webapp.controllers.user;


import com.kata.cinema.base.models.dto.WatchlistDto;
import com.kata.cinema.base.service.abstracts.WatchlistDtoService;
import com.kata.cinema.base.service.impl.WatchlistDtoServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping
    public ResponseEntity<List<WatchlistDto>> getWatchlistByUserId(@Positive @RequestParam Long userId) {
        return ResponseEntity.ok(watchlistDtoService.findAllWatchlistByUserId(userId));
    }


    @GetMapping("/{id}")
    public ResponseEntity<WatchlistDto> getWatchlistById(@Positive @PathVariable("id") Long id) {
        return ResponseEntity.ok(watchlistDtoService.findWatchlistDtoById(id));
    }

}
