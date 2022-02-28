package com.kata.cinema.base.service.impl.entity;

import com.kata.cinema.base.dao.abstracts.model.AbstractDao;
import com.kata.cinema.base.dao.abstracts.model.GenreDao;
import com.kata.cinema.base.models.entity.Genre;
import com.kata.cinema.base.service.abstracts.entity.GenreService;
import org.springframework.stereotype.Service;

@Service
public class GenreServiceImpl extends AbstractServiceImpl<Long, Genre> implements GenreService {

    private final GenreDao genreDao;

    protected GenreServiceImpl(AbstractDao<Long, Genre> abstractDao, GenreDao genreDao) {
        super(abstractDao);
        this.genreDao = genreDao;
    }
}
