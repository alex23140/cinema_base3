package com.kata.cinema.base.service.impl.entity;

import com.kata.cinema.base.dao.abstracts.model.UserDao;
import com.kata.cinema.base.models.entity.User;
import org.springframework.stereotype.Service;
import com.kata.cinema.base.service.abstracts.entity.UserService;

@Service
public class UserServiceImpl extends AbstractServiceImpl<Long, User> implements UserService {

    private final UserDao userDao;

    protected UserServiceImpl(UserDao userDao) {
        super(userDao);
        this.userDao = userDao;
    }
}
