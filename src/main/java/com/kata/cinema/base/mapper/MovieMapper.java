package com.kata.cinema.base.mapper;

import com.kata.cinema.base.models.dto.MovieDto;
import com.kata.cinema.base.models.entity.Movie;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MovieMapper extends AbstractMapper<MovieDto, Movie> {

}
