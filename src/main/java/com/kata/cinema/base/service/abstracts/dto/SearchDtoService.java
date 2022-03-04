package com.kata.cinema.base.service.abstracts.dto;

import com.kata.cinema.base.models.dto.SearchDto;
import com.kata.cinema.base.models.dto.SearchMovieDto;
import com.kata.cinema.base.models.dto.SearchPersonDto;

import java.util.List;

public interface SearchDtoService {

    List<SearchMovieDto> getFastSearchMovieDto(String notFullName, int limit);

    List<SearchPersonDto> getFastSearchPersonDto(String notFullName, int limit);

    SearchDto getSearchDto(String notFullName, int limit);

}
