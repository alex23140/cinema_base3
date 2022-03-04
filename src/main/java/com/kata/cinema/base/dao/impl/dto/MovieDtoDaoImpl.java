package com.kata.cinema.base.dao.impl.dto;

import com.kata.cinema.base.dao.abstracts.dto.MovieDtoDao;
import com.kata.cinema.base.models.dto.MovieDto;
import com.kata.cinema.base.models.dto.MoviePersonDto;
import com.kata.cinema.base.models.entity.Movie;
import com.kata.cinema.base.transformer.MovieDtoResultTransformer;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public class MovieDtoDaoImpl implements MovieDtoDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @SuppressWarnings("deprecation")
    public Optional<MoviePersonDto> getById(Long id) {
        try {
            return Optional.of((MoviePersonDto) entityManager.createQuery("""
                            SELECT
                            m.movie.id,
                            m.movie.name,
                            m.movie.country,
                            m.movie.description,
                            m.movie.previewIsExist,
                            m.movie.dateRelease,
                            g.name,
                            m.movie.rars,
                            m.movie.mpaa,
                            m.person.firstName,
                            m.person.lastName,
                            m.person.originalFirstName,
                            m.person.originalLastName,
                            m.nameCharacter,
                            m.type,
                            p.name
                            FROM MoviePersonInformation m
                            JOIN m.movie.genres g
                            JOIN m.professions p
                            WHERE m.movie.id= :id
                               AND (m.type <> 'MINOR_CHARACTER' OR m.type IS NULL)
                            """)
                    .setParameter("id", id)
                    .unwrap(org.hibernate.query.Query.class)
                    .setResultTransformer(new MovieDtoResultTransformer())
                    .getSingleResult());
        } catch (NoResultException e) {
            return Optional.empty();
        }
    }

    @Override
    public List<MovieDto> getItemsDto(Integer currentPage, Integer itemsOnPage, Map<String, Object> parameters) {
        return null;
    }

    @Override
    public Long getResultTotal(Map<String, Object> parameters) {
        return null;
    }
}
