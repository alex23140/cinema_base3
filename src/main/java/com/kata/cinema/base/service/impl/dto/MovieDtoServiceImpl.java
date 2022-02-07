package com.kata.cinema.base.service.impl.dto;

import com.kata.cinema.base.dao.abstracts.dto.MovieDtoDao;
import com.kata.cinema.base.models.dto.MovieDto;
import com.kata.cinema.base.service.abstracts.dto.MovieDtoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieDtoServiceImpl extends PaginationDtoServiceImpl<MovieDto> implements MovieDtoService {
    private final MovieDtoDao movieDtoDao;

    @Autowired
    public MovieDtoServiceImpl(MovieDtoDao movieDtoDao) {
        super(movieDtoDao);
        this.movieDtoDao = movieDtoDao;
    }

    @Override
    public MovieDto getById(Long id) {
        return movieDtoDao.getById(id);
    }
}
