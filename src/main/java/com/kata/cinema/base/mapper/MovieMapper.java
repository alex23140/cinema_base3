package com.kata.cinema.base.mapper;

import com.kata.cinema.base.models.dto.MovieDto;
import com.kata.cinema.base.models.entity.Movie;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface MovieMapper {
    MovieDto toDto(Movie movie);
    Movie toEntity(MovieDto movieDto);
}
