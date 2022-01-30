package com.kata.cinema.base.dao.impl.model;

import com.kata.cinema.base.dao.abstracts.model.UserDao;
import com.kata.cinema.base.models.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl extends AbstractDaoImpl<Long, User> implements UserDao {
}
