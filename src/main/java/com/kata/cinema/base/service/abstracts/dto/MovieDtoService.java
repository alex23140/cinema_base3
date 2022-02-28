package com.kata.cinema.base.service.abstracts.dto;

import com.kata.cinema.base.models.dto.MovieDto;
import com.kata.cinema.base.models.dto.MoviePersonDto;

import java.util.Optional;

public interface MovieDtoService extends PaginationDtoService<MovieDto>{
    Optional<MoviePersonDto> getById(Long id);
}
