package com.kata.cinema.base.mapper;

import com.kata.cinema.base.models.dto.MovieDto;
import com.kata.cinema.base.models.entity.Genre;
import com.kata.cinema.base.models.entity.Movie;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Mapper(componentModel = "spring")
public interface MovieMapper extends DtoMapper<MovieDto, Movie>, EntityMapper<MovieDto, Movie> {
}
