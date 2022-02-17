package com.kata.cinema.base.service.abstracts.dto;

import com.kata.cinema.base.models.dto.UserDto;

import java.util.Optional;

public interface UserDtoDaoService {
    Optional<UserDto> getById(long userId);
}
