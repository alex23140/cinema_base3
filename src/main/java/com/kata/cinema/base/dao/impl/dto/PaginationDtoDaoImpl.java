package com.kata.cinema.base.dao.impl.dto;

import com.kata.cinema.base.dao.abstracts.dto.PaginationDtoDao;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class PaginationDtoDaoImpl implements PaginationDtoDao {
    @Override
    public List getItemsDto(Integer currentPage, Integer itemsOnPage, Map parameters) {
        return null;
    }

    @Override
    public Long getResultTotal(Map parameters) {
        return null;
    }
}
