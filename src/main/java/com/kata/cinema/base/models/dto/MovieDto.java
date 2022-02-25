package com.kata.cinema.base.models.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.kata.cinema.base.models.entity.Genre;
import com.kata.cinema.base.models.entity.Person;
import com.kata.cinema.base.models.enums.MPAA;
import com.kata.cinema.base.models.enums.RARS;
import lombok.*;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"id", "name"})
public class MovieDto {
    private Long id;

    @NotBlank
    private String name;
    private String country;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy")
    private LocalDate dateRelease;

    private RARS rars;
    private MPAA mpaa;
    private String description;
    private Boolean previewIsExist = false;

    private List<GenreDto> genres;
}
