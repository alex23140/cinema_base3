package com.kata.cinema.base.dao.abstracts.model;

import com.kata.cinema.base.models.entity.Movie;

import java.util.List;

public interface MovieDao extends AbstractDao<Long, Movie> {
    List<Movie> getListOfMoviesById(List<Long> moviesId);
}
