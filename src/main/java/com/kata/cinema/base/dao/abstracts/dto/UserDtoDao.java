package com.kata.cinema.base.dao.abstracts.dto;

import com.kata.cinema.base.models.dto.UserDto;

public interface UserDtoDao {
    UserDto toDto(long userId);
}
