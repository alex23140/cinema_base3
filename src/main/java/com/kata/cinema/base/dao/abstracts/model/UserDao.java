package com.kata.cinema.base.dao.abstracts.model;

import com.kata.cinema.base.models.entity.User;

import java.util.Optional;

public interface UserDao extends AbstractDao<Long, User> {
    Optional<User> getUserByEmail(String email);
}
