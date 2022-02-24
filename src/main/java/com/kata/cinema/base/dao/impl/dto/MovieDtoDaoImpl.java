package com.kata.cinema.base.dao.impl.dto;

import com.kata.cinema.base.dao.abstracts.dto.MovieDtoDao;
import com.kata.cinema.base.dao.abstracts.dto.PaginationDtoDao;
import com.kata.cinema.base.models.dto.MovieDto;
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
    public Optional<MovieDto> getById(Long id) {
        try {
            return Optional.of(entityManager.createQuery("""
                            SELECT NEW com.kata.cinema.base.models.dto.MovieDto(
                            m.id,
                            m.name,
                            m.originName,
                            m.country,
                            m.dateRelease,
                            m.rars,
                            m.mpaa,
                            m.description,
                            m.previewIsExist)
                            FROM Movie m
                            WHERE m.id= :id
                            """, MovieDto.class)
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
