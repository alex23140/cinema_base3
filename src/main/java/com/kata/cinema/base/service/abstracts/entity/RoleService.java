package com.kata.cinema.base.service.abstracts.entity;

import com.kata.cinema.base.models.entity.Role;

public interface RoleService extends AbstractService<Long, Role>{
    Role getRoleByName(String name);
}
