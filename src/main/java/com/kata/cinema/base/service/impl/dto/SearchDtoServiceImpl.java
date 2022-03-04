package com.kata.cinema.base.service.impl.dto;

import com.kata.cinema.base.dao.abstracts.dto.SearchDtoDao;
import com.kata.cinema.base.models.dto.SearchDto;
import com.kata.cinema.base.models.dto.SearchMovieDto;
import com.kata.cinema.base.models.dto.SearchPersonDto;
import com.kata.cinema.base.service.abstracts.dto.SearchDtoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchDtoServiceImpl implements SearchDtoService {
    private final SearchDtoDao searchDtoDao;

    @Autowired
    public SearchDtoServiceImpl(SearchDtoDao searchDtoDao) {
        this.searchDtoDao = searchDtoDao;

    }

    @Override
    public List<SearchMovieDto> getFastSearchMovieDto(String notFullName, int limit) {
        return searchDtoDao.getFastSearchMovieDto(notFullName, limit);
    }

    @Override
    public List<SearchPersonDto> getFastSearchPersonDto(String notFullName, int limit) {
        return searchDtoDao.getFastSearchPersonDto(notFullName, limit);
    }

    @Override
    public SearchDto getSearchDto(String notFullName, int limit) {
        List<SearchMovieDto> movies = searchDtoDao.getFastSearchMovieDto(notFullName, limit);
        List<SearchPersonDto> persons = searchDtoDao.getFastSearchPersonDto(notFullName, limit);
        SearchDto searchDto = new SearchDto(movies, persons);
        return searchDto;
    }
}
