package com.kata.cinema.base.webapp.controllers.user;

import com.kata.cinema.base.mapper.UserMapper;
import com.kata.cinema.base.models.dto.UserDto;
import com.kata.cinema.base.service.abstracts.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.util.List;

public class UserRestController {

    @Autowired
    private UserService userService;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private EntityManagerFactory entityManagerFactory;

    @PutMapping("/api/user")
    public ResponseEntity<UserDto> edit(@RequestBody UserDto userDto){
        userService.update(userMapper.toEntity(userDto));
        return ResponseEntity.ok(userDto);
    }

    @DeleteMapping(value = "/api/user/{id}")
    public ResponseEntity deleteUser(@PathVariable("id") Long id){
        userService.deleteById(id);
        return ResponseEntity.ok("Deleted");
    }

    @GetMapping(value = "/api/users/{id}")
    public List<UserDto> getUser(@PathVariable("id") long id){

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
                .setParameter("id",id)
                .getResultList();

    }

}
