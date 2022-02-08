package com.kata.cinema.base.mapper;

import com.kata.cinema.base.models.dto.NewsDto;
import com.kata.cinema.base.models.entity.News;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface NewsMapper {
    News toEntity(NewsDto newsDto);
}
