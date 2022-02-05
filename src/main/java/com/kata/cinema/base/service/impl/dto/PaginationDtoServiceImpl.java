package com.kata.cinema.base.service.impl.dto;

import com.kata.cinema.base.dao.abstracts.dto.PaginationDtoDao;
import com.kata.cinema.base.models.dto.PageDto;
import com.kata.cinema.base.service.abstracts.PaginationDtoService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class PaginationDtoServiceImpl<T> implements PaginationDtoService<T> {

    private final PaginationDtoDao<T> tPaginationDtoDao;

    public PaginationDtoServiceImpl(PaginationDtoDao<T> tPaginationDtoDao) {
        this.tPaginationDtoDao = tPaginationDtoDao;
    }

    @Override
    public PageDto<T> getPageDto(Integer currentPage, Integer itemsOnPage) {
        return null;
                // return new PageDto<T>( tPaginationDtoDao.getResultTotal(parameters) ,
                //                tPaginationDtoDao.getItemsDto(currentPage,itemsOnPage, parameters)  );
    }

    @Override
    public Page<T> getPageDtoWithParameters(Integer currentPage, Integer itemsOnPage, Map<String, Object> parameters) {
        return null;
    }
}
