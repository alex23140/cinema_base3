package com.kata.cinema.base.service.abstracts;

import com.kata.cinema.base.models.dto.NewsDto;
import com.kata.cinema.base.models.entity.News;
import com.kata.cinema.base.models.enums.Rubric;

import java.time.LocalDateTime;
import java.util.List;

public interface NewsService extends AbstractService<Long, News> {

    List<NewsDto> getAllByDateAndRubric(LocalDateTime startDate, LocalDateTime endDate, Rubric rubric);

    void saveNews(NewsDto newsDto);
}
