package com.kata.cinema.base.dao.impl.dto;

import com.kata.cinema.base.dao.abstracts.dto.PaginationDtoDao;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class PaginationDtoDaoImpl<T> implements PaginationDtoDao<T> {

    @Override
    public List<T> getItemsDto(Integer currentPage, Integer itemsOnPage, Map<String, Object> parameters) {
        return null;
    }

    @Override
    public Long getResultTotal(Map<String, Object> parameters) {
        return null;
    }
}
