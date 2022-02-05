package com.kata.cinema.base.dao.abstracts.dto;

import com.kata.cinema.base.models.dto.NewsDto;
import com.kata.cinema.base.models.entity.News;
import com.kata.cinema.base.models.enums.Rubric;

import java.time.LocalDateTime;
import java.util.List;

public interface NewsDtoDao {
    List<NewsDto> getAllByDateAndRubric(LocalDateTime startDate, LocalDateTime endDate, Rubric rubric);
}
