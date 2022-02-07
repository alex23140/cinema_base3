package com.kata.cinema.base.service.abstracts.dto;

import com.kata.cinema.base.models.dto.NewsDto;
import com.kata.cinema.base.models.enums.Rubric;

import java.time.LocalDateTime;
import java.util.List;

public interface NewsDtoService {
    List<NewsDto> getAllByDateAndRubric(LocalDateTime startDate, LocalDateTime endDate, Rubric rubric);
}
