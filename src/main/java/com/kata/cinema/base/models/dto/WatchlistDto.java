package com.kata.cinema.base.models.dto;

import com.kata.cinema.base.models.enams.Category;
import com.kata.cinema.base.models.enams.Privacy;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class WatchlistDto {
    Long id;
    Category category;
    Privacy privacy;
    String name;
    String description;
    Long userId;
}
