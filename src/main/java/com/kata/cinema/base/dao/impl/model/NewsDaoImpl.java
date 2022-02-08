package com.kata.cinema.base.dao.impl.model;

import com.kata.cinema.base.dao.abstracts.model.NewsDao;
import com.kata.cinema.base.models.entity.News;
import org.springframework.stereotype.Repository;

@Repository
public class NewsDaoImpl extends AbstractDaoImpl<Long, News> implements NewsDao {
}
