package com.kata.cinema.base.mapper;

import com.kata.cinema.base.models.dto.UserRegistrationDto;
import com.kata.cinema.base.models.entity.User;
import org.mapstruct.Mapper;

@Mapper
public interface UserRegistrationMapper {
    User toEntity(UserRegistrationDto userRegistrationDto);
    UserRegistrationDto toDto(User user);
}
