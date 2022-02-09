package com.kata.cinema.base.mapper;

import com.kata.cinema.base.models.dto.UserRegistrationDto;
import com.kata.cinema.base.models.entity.User;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface UserRegistrationMapper {
    User toEntity(UserRegistrationDto userRegistrationDto);
    UserRegistrationDto toDto(User user);
}
