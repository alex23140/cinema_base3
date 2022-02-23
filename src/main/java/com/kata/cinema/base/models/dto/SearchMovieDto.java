package com.kata.cinema.base.models.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SearchMovieDto {
    private Long id;
    private String name;
    private String originName;
    private LocalDate dateRelease;
    private Boolean previewIsExist;
}
