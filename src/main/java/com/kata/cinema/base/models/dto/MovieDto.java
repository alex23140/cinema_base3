package com.kata.cinema.base.models.dto;

import com.kata.cinema.base.models.entity.Genre;
import com.kata.cinema.base.models.enums.MPAA;
import com.kata.cinema.base.models.enums.RARS;
import lombok.*;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"id", "name"})
@Component
public class MovieDto {
    private Long id;

    @NotBlank
    private String name;
    private String country;
    private LocalDate year;
    private RARS ageRating;
    private MPAA filmRating;
    private String description;
    private Boolean previewIsExist = false;

    //TODO добавить связь Movie и Genre
    //private List<Genre> genres;
}
