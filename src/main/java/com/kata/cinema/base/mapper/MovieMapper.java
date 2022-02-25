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

//    @Mapping(target = "genres", qualifiedByName = "genresToStrings")
//    MovieDto toDto(Movie movie);
//
//    @Mapping(target = "genres", qualifiedByName = "stringsToGenres")
//    Movie toEntity(MovieDto movieDto);
//
//    @Named("genresToStrings")
//    static List<String> genresToStrings(Set<Genre> genres) {
//        if (genres == null) {
//            return null;
//        }
//
//        List<String> names = new ArrayList<>();
//        for (Genre genre : genres) {
//            names.add(genre.getName());
//        }
//
//        return names;
//    }
//
//    @Named("stringsToGenres")
//    static Set<Genre> stringsToGenres(List<String> names) {
//        if (names == null) {
//            return null;
//        }
//
//        Set<Genre> genres = new HashSet<>();
//        for (String name : names) {
//            Genre genre = new Genre();
//            genre.setName(name);
//            genres.add(genre);
//        }
//
//        return genres;
//    }
}
