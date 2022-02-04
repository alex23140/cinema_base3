package com.kata.cinema.base.mappers;

import com.kata.cinema.base.models.dto.NewsDto;
import com.kata.cinema.base.models.entity.News;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface NewsMapper {

    NewsMapper INSTANCE = Mappers.getMapper(NewsMapper.class);

    News toEntity(NewsDto newsDto);
}
