package com.kata.cinema.base.service.impl.dto;

import com.kata.cinema.base.dao.abstracts.dto.UserDtoDao;
import com.kata.cinema.base.models.dto.UserDto;
import com.kata.cinema.base.service.abstracts.dto.UserDtoDaoService;
import org.springframework.stereotype.Service;

@Service
public class UserDtoDaoServiceImpl implements UserDtoDaoService {

    private final UserDtoDao userDtoDao;

    public UserDtoDaoServiceImpl(UserDtoDao userDtoDao) {
        this.userDtoDao = userDtoDao;
    }

    @Override
    public UserDto getById(long userId) {
        return userDtoDao.getById(userId);
    }
}
