package com.kata.cinema.base.service.impl.dto;

import com.kata.cinema.base.dao.abstracts.dto.SearchDtoDao;
import com.kata.cinema.base.models.dto.SearchDto;
import com.kata.cinema.base.models.dto.SearchMovieDto;
import com.kata.cinema.base.service.abstracts.dto.SearchDtoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SearchDtoServiceImpl implements SearchDtoService {
    private final SearchDtoDao searchDtoDao;

    @Override
    public List<SearchMovieDto> getFastSearchMovieDto(String notFullName) {
        return searchDtoDao.getFastSearchMovieDto(notFullName);
    }

    @Autowired
    public SearchDtoServiceImpl(SearchDtoDao searchDtoDao) {
        this.searchDtoDao = searchDtoDao;
    }

    @Override
    public Optional<SearchDto> getSearchDto(int limit) {
        return searchDtoDao.getSearchDto(limit);
    }
}
