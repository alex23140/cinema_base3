package com.kata.cinema.base.mapper;

import com.kata.cinema.base.models.dto.UserRegistrationDto;
import com.kata.cinema.base.models.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserRegistrationMapper extends DtoMapper<UserRegistrationDto, User>, EntityMapper<UserRegistrationDto, User> {

}
