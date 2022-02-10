package com.kata.cinema.base.service.abstracts.dto;

import com.kata.cinema.base.models.dto.UserDto;

public interface UserDtoDaoService {
    UserDto getById(long userId);
}
