package com.kata.cinema.base.service.impl.entity;

import com.kata.cinema.base.dao.abstracts.model.AbstractDao;
import com.kata.cinema.base.dao.abstracts.model.RoleDao;
import com.kata.cinema.base.models.entity.Role;
import com.kata.cinema.base.service.abstracts.entity.RoleService;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl extends AbstractServiceImpl<Long, Role> implements RoleService {

    private final RoleDao roleDao;

    protected RoleServiceImpl(AbstractDao<Long, Role> abstractDao, RoleDao roleDao) {
        super(abstractDao);
        this.roleDao = roleDao;
    }

    public Role getRoleByName(String name) {
        return roleDao.getRoleByName(name);
    }
}
