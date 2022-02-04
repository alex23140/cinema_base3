package com.kata.cinema.base.webapp.controllers.user;

import com.kata.cinema.base.dao.abstracts.model.UserDtoDao;
import com.kata.cinema.base.mapper.UserMapper;
import com.kata.cinema.base.models.dto.UserDto;
import com.kata.cinema.base.service.abstracts.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
public class UserRestController {

    private final UserService userService;
    private final UserMapper userMapper;
    private final UserDtoDao userDtoDao;

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
    public UserDto getUser(@PathVariable("id") long id){

        return userDtoDao.toDto(id);

    }

}
