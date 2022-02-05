package com.kata.cinema.base.service.abstracts;

import com.kata.cinema.base.models.dto.PageDto;
import org.springframework.data.domain.Page;

import java.util.Map;

public interface PaginationDtoService<T> {
    PageDto<T> getPageDto(Integer currentPage, Integer itemsOnPage);
    Page<T> getPageDtoWithParameters(Integer currentPage, Integer itemsOnPage, Map<String, Object> parameters);
}
