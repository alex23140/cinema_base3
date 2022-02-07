package com.kata.cinema.base.dao.abstracts.dto;

import com.kata.cinema.base.models.dto.MovieDto;

public interface MovieDtoDao extends  PaginationDtoDao<MovieDto>{
    MovieDto getById(Long id);
}
