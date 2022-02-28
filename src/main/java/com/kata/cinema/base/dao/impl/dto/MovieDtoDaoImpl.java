package com.kata.cinema.base.dao.impl.dto;

import com.kata.cinema.base.dao.abstracts.dto.MovieDtoDao;
import com.kata.cinema.base.models.dto.MovieDto;
import com.kata.cinema.base.models.dto.MoviePersonDto;
import com.kata.cinema.base.transformer.MovieDtoResultTransformer;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
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
                            SELECT  m.country,
                                    m.dateRelese,
                                    m.description,
                                    m.mpaa,
                                    m.name,
                                    m.previewIsExist,
                                    m.rars,
                                    g.name,
                                    p.birthday,
                                    p.first_name,
                                    p.growth,
                                    p.last_name,
                                    p.place_of_birth,
                                    pr.name
                            FROM Movie m
                            JOIN m.genres
                            WHERE m.id= :id
                            """)
                    .setParameter("id", id)
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
