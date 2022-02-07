package com.kata.cinema.base.service.impl.dto;

import com.kata.cinema.base.dao.abstracts.dto.PaginationDtoDao;
import com.kata.cinema.base.models.dto.PageDto;
import com.kata.cinema.base.service.abstracts.dto.PaginationDtoService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;


public abstract class PaginationDtoServiceImpl<T> implements PaginationDtoService<T> {

    private final PaginationDtoDao<T> tPaginationDtoDao;

    public PaginationDtoServiceImpl(PaginationDtoDao<T> tPaginationDtoDao) {
        this.tPaginationDtoDao = tPaginationDtoDao;
    }

    @Override
    public PageDto<T> getPageDto(Integer currentPage, Integer itemsOnPage) {
        return getPageDtoWithParameters(currentPage,itemsOnPage, new HashMap<>());
    }

    @Override
    public PageDto<T> getPageDtoWithParameters(Integer currentPage, Integer itemsOnPage, Map<String, Object> parameters) {
        return null;
        // ?????
    }
}
