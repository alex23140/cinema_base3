package com.kata.cinema.base.models.dto;

import com.kata.cinema.base.models.entity.Genre;
import com.kata.cinema.base.models.enums.MPAA;
import com.kata.cinema.base.models.enums.RARS;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = {"id", "name"})
public class MovieDto {
    private Long id;
    private String name;
    private String country;
    private LocalDate year;
    private RARS ageRating;
    private MPAA filmRating;
    private String description;
    private Boolean previewIsExist = false;
    private Set<Genre> genres;
}
