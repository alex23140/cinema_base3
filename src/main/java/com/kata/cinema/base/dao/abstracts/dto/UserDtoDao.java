package com.kata.cinema.base.dao.abstracts.dto;

import com.kata.cinema.base.models.dto.UserDto;

import java.util.Optional;

public interface UserDtoDao {
    Optional<UserDto> getById(long userId);
}
