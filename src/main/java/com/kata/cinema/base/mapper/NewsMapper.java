package com.kata.cinema.base.mapper;

import com.kata.cinema.base.models.dto.NewsDto;
import com.kata.cinema.base.models.entity.News;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface NewsMapper extends AbstractMapper<NewsDto, News> {

}
