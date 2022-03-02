package com.kata.cinema.base.dao.impl.model;

import com.kata.cinema.base.dao.abstracts.model.GenreDao;
import com.kata.cinema.base.models.entity.Genre;
import org.springframework.stereotype.Repository;


@Repository
public class GenreDaoImpl extends AbstractDaoImpl<Long, Genre> implements GenreDao {
}
