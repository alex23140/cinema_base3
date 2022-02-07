package com.kata.cinema.base.dao.impl.dto;

import com.kata.cinema.base.dao.abstracts.dto.NewsDtoDao;
import com.kata.cinema.base.models.dto.NewsDto;
import com.kata.cinema.base.models.enums.Rubric;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public class NewsDtoDaoImpl implements NewsDtoDao {

    @PersistenceContext
    protected EntityManager entityManager;

    @Override
    public List<NewsDto> getAllByDateAndRubric(LocalDateTime startDate, LocalDateTime endDate, Rubric rubric) {

        return entityManager.createQuery("""
                SELECT new com.kata.cinema.base.models.dto.NewsDto(n.id, n.rubric, n.date, n.title, n.description)
                FROM News n
                WHERE n.rubric = :rubric
                AND n.date <= :endDate
                AND n.date >= :startDate
                """, NewsDto.class)
                .setParameter("rubric", rubric)
                .setParameter("endDate", endDate)
                .setParameter("startDate", startDate)
                .getResultList();
    }
}
