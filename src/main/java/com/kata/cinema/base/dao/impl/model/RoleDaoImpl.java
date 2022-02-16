package com.kata.cinema.base.dao.impl.model;

import com.kata.cinema.base.dao.abstracts.model.RoleDao;
import com.kata.cinema.base.models.entity.Role;
import org.springframework.stereotype.Repository;

@Repository
public class RoleDaoImpl extends AbstractDaoImpl<Long, Role> implements RoleDao {
}
