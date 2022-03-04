package com.kata.cinema.base.dao.abstracts.dto;

import com.kata.cinema.base.models.dto.SearchMovieDto;
import com.kata.cinema.base.models.dto.SearchPersonDto;

import java.util.List;

public interface SearchDtoDao {
    List<SearchMovieDto> getFastSearchMovieDto(String notFullName, int limit);

    List<SearchPersonDto> getFastSearchPersonDto(String notFullName, int limit);
}
