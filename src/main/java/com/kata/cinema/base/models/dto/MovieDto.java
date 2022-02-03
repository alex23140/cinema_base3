package com.kata.cinema.base.models.dto;

import com.kata.cinema.base.models.entity.Genre;
import com.kata.cinema.base.models.enums.MPAA;
import com.kata.cinema.base.models.enums.RARS;
import lombok.*;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"id", "name"})
@Component
public class MovieDto {
    private Long id;
    private String name;
    private String country;
    private LocalDate year;
    private RARS ageRating;
    private MPAA filmRating;
    private String description;
    private Boolean previewIsExist = false;
   // private Set<Genre> genres;
}
