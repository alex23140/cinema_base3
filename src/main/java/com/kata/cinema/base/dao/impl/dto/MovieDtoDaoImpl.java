package com.kata.cinema.base.dao.impl.dto;

import com.kata.cinema.base.dao.abstracts.dto.MovieDtoDao;
import com.kata.cinema.base.models.dto.MovieDto;
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
    public MovieDto getById(Long id) {
        // TODO убрать конструктор, делать селект movie и в трансформере оборачивать в dto
        return (MovieDto) entityManager.createQuery(
                        "")
                .unwrap(Query.class)
                .setResultTransformer(new MovieDtoResultTransformer())
                .getSingleResult();
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
