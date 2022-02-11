package com.kata.cinema.base.dao.impl.dto;

import com.kata.cinema.base.dao.abstracts.dto.UserDtoDao;
import com.kata.cinema.base.models.dto.UserDto;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class UserDtoDaoImpl implements UserDtoDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    //TODO поменять наименование метода
    public UserDto getById(long userId) {
        return entityManager.createQuery("""
                        SELECT NEW com.kata.cinema.base.models.dto.UserDto(
                        u.id, 
                        u.email, 
                        u.nickname, 
                        u.firstName, 
                        u.lastName, 
                        u.password, 
                        u.birthday) 
                        FROM User u 
                        WHERE u.id= :id
                        """, UserDto.class)
                .setParameter("id",userId)
                .getSingleResult();
    }
}
