package com.kata.cinema.base.dao.impl.dto;

import com.kata.cinema.base.dao.abstracts.dto.UserDtoDao;
import com.kata.cinema.base.models.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

@Repository
public class UserDtoDaoImpl implements UserDtoDao {

    @Autowired
    private EntityManagerFactory entityManagerFactory;

    @Override
    //TODO поменять наименование метода
    public UserDto toDto(long userId) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

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
                        """ ,UserDto.class)
                .setParameter("id",userId)
                .getSingleResult();
    }
}
