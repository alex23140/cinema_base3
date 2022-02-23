package com.kata.cinema.base.models.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SearchDto {
    List<SearchMovieDto> movies;
    List<SearchPersonDto> persons;
}
