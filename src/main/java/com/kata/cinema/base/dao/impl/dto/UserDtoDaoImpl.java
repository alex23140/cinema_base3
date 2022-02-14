package com.kata.cinema.base.dao.impl.dto;

import com.kata.cinema.base.dao.abstracts.dto.UserDtoDao;
import com.kata.cinema.base.models.dto.UserDto;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import java.util.Optional;

@Repository
public class UserDtoDaoImpl implements UserDtoDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Optional<UserDto> getById(long userId) {
        try {
            return Optional.of(entityManager.createQuery("""
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
                    .setParameter("id", userId)
                    .getSingleResult());
        } catch (NoResultException e) {
            return Optional.empty();
        }
    }
}
