package com.kata.cinema.base.service.abstracts.dto;

import com.kata.cinema.base.models.dto.MovieDto;

public interface MovieDtoService {
    MovieDto getById(Long id);
}