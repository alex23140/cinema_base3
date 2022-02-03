package com.kata.cinema.base.mapper;

import com.kata.cinema.base.models.dto.UserDto;
import com.kata.cinema.base.models.entity.User;
import org.mapstruct.Mapper;

@Mapper
public interface UserMapper {
    UserDto toDto(User user);
    User toEntity(UserDto user);
}
