package com.kata.cinema.base.dao.impl.model;

import com.kata.cinema.base.dao.abstracts.model.MovieDao;
import com.kata.cinema.base.models.entity.Movie;
import org.springframework.stereotype.Repository;

@Repository
public class MovieDaoImpl extends AbstractDaoImpl<Long, Movie> implements MovieDao {
}
