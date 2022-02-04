package com.kata.cinema.base.dao.abstracts.model;

import com.kata.cinema.base.models.dto.UserDto;
import com.kata.cinema.base.models.entity.User;

public interface UserDtoDao {
    UserDto toDto(long userId);
}
