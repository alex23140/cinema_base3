package com.kata.cinema.base.service.impl;

import com.kata.cinema.base.dao.abstracts.model.NewsDao;
import com.kata.cinema.base.models.dto.NewsDto;
import com.kata.cinema.base.models.entity.News;
import com.kata.cinema.base.models.enums.Rubric;
import com.kata.cinema.base.service.abstracts.NewsService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class NewsServiceImpl extends AbstractServiceImpl<Long, News> implements NewsService {

    private final NewsDao newsDao;

    public NewsServiceImpl(NewsDao newsDao) {
        super(newsDao);
        this.newsDao = newsDao;
    }

    @Override
    public List<NewsDto> getAllByDateAndRubric(LocalDateTime startDate, LocalDateTime endDate, Rubric rubric) {
        return newsDao.getAllByDateAndRubric(startDate, endDate, rubric);
    }

    @Override
    public void saveNews(NewsDto newsDto) {
        newsDao.saveNews(newsDto);
    }

}
