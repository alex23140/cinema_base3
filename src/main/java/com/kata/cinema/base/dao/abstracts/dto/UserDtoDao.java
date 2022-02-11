package com.kata.cinema.base.dao.abstracts.dto;

import com.kata.cinema.base.models.dto.UserDto;
import com.kata.cinema.base.models.entity.User;

public interface UserDtoDao {
    UserDto getById(long userId);
}
