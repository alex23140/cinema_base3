package com.kata.cinema.base.service.impl.entity;

import com.kata.cinema.base.dao.abstracts.model.NewsDao;
import com.kata.cinema.base.models.entity.News;

import com.kata.cinema.base.service.abstracts.entity.NewsService;
import org.springframework.stereotype.Service;

@Service
public class NewsServiceImpl extends AbstractServiceImpl<Long, News> implements NewsService {

    private final NewsDao newsDao;

    public NewsServiceImpl(NewsDao newsDao) {
        super(newsDao);
        this.newsDao = newsDao;
    }
}
