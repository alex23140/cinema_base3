package com.kata.cinema.base.dao.impl.model;

import com.kata.cinema.base.dao.abstracts.model.NewsDao;
import com.kata.cinema.base.mappers.NewsMapper;
import com.kata.cinema.base.models.dto.NewsDto;
import com.kata.cinema.base.models.entity.News;
import com.kata.cinema.base.models.enums.Rubric;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public class NewsDaoImpl extends AbstractDaoImpl<Long, News> implements NewsDao {

    @Override
    public List<NewsDto> getAllByDateAndRubric(LocalDateTime startDate, LocalDateTime endDate, Rubric rubric) {
        String SQL = """
                SELECT new com.kata.cinema.base.models.dto.NewsDto(n.id, n.rubric, n.date, n.title, n.description)
                FROM News n
                WHERE n.rubric = :rubric
                AND n.date <= :endDate
                AND n.date >= :startDate
                """;

        return entityManager.createQuery(SQL, NewsDto.class)
                .setParameter("rubric", rubric)
                .setParameter("endDate", endDate)
                .setParameter("startDate", startDate)
                .getResultList();
    }

    @Override
    @Transactional
    public void saveNews(NewsDto newsDto) {
        entityManager.persist(NewsMapper.INSTANCE.toEntity(newsDto));
    }
}
