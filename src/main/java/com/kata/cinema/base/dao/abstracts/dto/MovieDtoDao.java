package com.kata.cinema.base.dao.abstracts.dto;

import com.kata.cinema.base.models.dto.MovieDto;

public interface MovieDtoDao {
    MovieDto getById(Long id);
}
