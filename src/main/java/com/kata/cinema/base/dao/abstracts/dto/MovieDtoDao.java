package com.kata.cinema.base.dao.abstracts.dto;

import com.kata.cinema.base.models.dto.MovieDto;
import com.kata.cinema.base.models.dto.MoviePersonDto;

import java.util.Optional;

public interface MovieDtoDao extends PaginationDtoDao<MovieDto> {
    Optional<MoviePersonDto> getById(Long id);
}
