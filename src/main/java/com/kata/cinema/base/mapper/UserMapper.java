package com.kata.cinema.base.mapper;

import com.kata.cinema.base.models.dto.MovieDto;
import com.kata.cinema.base.models.dto.UserDto;
import com.kata.cinema.base.models.entity.Movie;
import com.kata.cinema.base.models.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper extends DtoMapper<UserDto, User>, EntityMapper<UserDto, User> {

}
