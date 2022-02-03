package com.kata.cinema.base.service.impl;

import com.kata.cinema.base.dao.abstracts.model.MovieDtoDao;
import com.kata.cinema.base.models.dto.MovieDto;
import com.kata.cinema.base.service.abstracts.MovieDtoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieDtoServiceImpl implements MovieDtoService {
    private final MovieDtoDao movieDtoDao;

    @Autowired
    public MovieDtoServiceImpl(MovieDtoDao movieDtoDao) {
        this.movieDtoDao = movieDtoDao;
    }

    @Override
    public MovieDto getById(Long id) {
        return movieDtoDao.getById(id);
    }
}
