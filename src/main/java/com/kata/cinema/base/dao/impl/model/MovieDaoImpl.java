package com.kata.cinema.base.dao.impl.model;

import com.kata.cinema.base.dao.abstracts.model.MovieDao;
import com.kata.cinema.base.models.entity.Movie;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MovieDaoImpl extends AbstractDaoImpl<Long, Movie> implements MovieDao {
    @Override
    public List<Movie> getListOfMoviesById(List<Long> moviesId) {
        return entityManager.createQuery("SELECT m FROM Movie m WHERE m.id IN (:moviesId)", Movie.class)
                .setParameter("moviesId", moviesId)
                .getResultList();
    }
}
