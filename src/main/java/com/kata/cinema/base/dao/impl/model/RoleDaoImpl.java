package com.kata.cinema.base.dao.impl.model;

import com.kata.cinema.base.dao.abstracts.model.RoleDao;
import com.kata.cinema.base.models.entity.Role;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class RoleDaoImpl extends AbstractDaoImpl<Long, Role> implements RoleDao {

    @PersistenceContext
    private EntityManager entityManager;

    public Role getRoleByName(String name) {
        String hql = "select r as name from Role r where r.name = :name";
        Role query = (Role) entityManager.createQuery(hql).setParameter("name", name).getSingleResult();
        return query;
    }
}
