package com.kata.cinema.base.service.impl.dto;

import com.kata.cinema.base.dao.abstracts.dto.NewsDtoDao;
import com.kata.cinema.base.models.dto.NewsDto;
import com.kata.cinema.base.models.enums.Rubric;
import com.kata.cinema.base.service.abstracts.dto.NewsDtoService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class NewsDtoServiceImpl implements NewsDtoService {

    private final NewsDtoDao newsDtoDao;

    public NewsDtoServiceImpl(NewsDtoDao newsDtoDao) {
        this.newsDtoDao = newsDtoDao;
    }

    @Override
    public List<NewsDto> getAllByDateAndRubric(LocalDateTime startDate, LocalDateTime endDate, Rubric rubric) {
        return newsDtoDao.getAllByDateAndRubric(startDate, endDate, rubric);
    }
}
