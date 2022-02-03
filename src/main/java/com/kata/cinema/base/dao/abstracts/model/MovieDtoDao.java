package com.kata.cinema.base.dao.abstracts.model;

import com.kata.cinema.base.models.dto.MovieDto;

public interface MovieDtoDao {
    MovieDto getById(Long id);
}
