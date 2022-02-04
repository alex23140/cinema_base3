package com.kata.cinema.base.dao.abstracts.model;

import com.kata.cinema.base.models.dto.NewsDto;
import com.kata.cinema.base.models.entity.News;
import com.kata.cinema.base.models.enums.Rubric;
import java.time.LocalDateTime;
import java.util.List;

public interface NewsDao extends AbstractDao<Long, News> {

    List<NewsDto> getAllByDateAndRubric(LocalDateTime startDate, LocalDateTime endDate, Rubric rubric);

    void saveNews(NewsDto newsDto);
}
