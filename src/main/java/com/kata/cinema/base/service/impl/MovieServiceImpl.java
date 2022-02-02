package com.kata.cinema.base.service.impl;

import com.kata.cinema.base.dao.abstracts.model.MovieDao;

import com.kata.cinema.base.models.entity.Movie;
import com.kata.cinema.base.service.abstracts.MovieService;
import org.springframework.stereotype.Service;

@Service
public class MovieServiceImpl extends AbstractServiceImpl<Long, Movie> implements MovieService {

    private final MovieDao movieDao;

    protected MovieServiceImpl(MovieDao movieDao) {
        super(movieDao);
        this.movieDao = movieDao;
    }
}
