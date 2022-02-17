package com.kata.cinema.base.service.abstracts.entity;

import com.kata.cinema.base.models.entity.Movie;

import java.util.List;

public interface MovieService extends AbstractService<Long, Movie> {
    List<Movie> getListOfMoviesById(List<Long> moviesId);
}
