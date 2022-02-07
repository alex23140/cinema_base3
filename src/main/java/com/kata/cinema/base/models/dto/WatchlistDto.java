package com.kata.cinema.base.models.dto;

import com.kata.cinema.base.models.enums.Category;
import com.kata.cinema.base.models.enums.Privacy;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class WatchlistDto {
    private Long id;
    private Category category;
    private Privacy privacy;
    private String name;
    private String description;
    private Long userId;
}
