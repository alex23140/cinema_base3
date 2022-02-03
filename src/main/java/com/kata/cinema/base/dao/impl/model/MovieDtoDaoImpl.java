package com.kata.cinema.base.dao.impl.model;

import com.kata.cinema.base.dao.abstracts.model.MovieDtoDao;
import com.kata.cinema.base.models.dto.MovieDto;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class MovieDtoDaoImpl implements MovieDtoDao {
    @PersistenceContext
    protected EntityManager entityManager;

    @Override
    public MovieDto getById(Long id) {
        return entityManager.createQuery("""
                        SELECT NEW com.kata.cinema.base.models.dto.MovieDto(
                        m.id,
                        m.name,
                        m.country,
                        m.year,
                        m.ageRating,
                        m.filmRating,
                        m.description,
                        m.previewIsExist)
                        FROM Movie m
                        WHERE m.id= :id
                        """, MovieDto.class)
                .setParameter("id", id)
                .getSingleResult();
    }
}
