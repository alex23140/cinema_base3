package com.kata.cinema.base.service.abstracts;

import com.kata.cinema.base.models.dto.MovieDto;

public interface MovieDtoService {
    MovieDto getById(Long id);
}
