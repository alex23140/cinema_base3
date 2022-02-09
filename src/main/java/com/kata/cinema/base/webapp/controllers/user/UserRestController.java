package com.kata.cinema.base.webapp.controllers.user;

import com.kata.cinema.base.dao.abstracts.dto.UserDtoDao;
import com.kata.cinema.base.mapper.UserMapper;
import com.kata.cinema.base.models.dto.UserDto;
import com.kata.cinema.base.service.abstracts.entity.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;

@AllArgsConstructor
@RequestMapping("/api/user")
@Validated
public class UserRestController {

    private final UserService userService;
    private final UserMapper userMapper;
    //создать сервис
    private final UserDtoDao userDtoDao;

    @PutMapping
    public ResponseEntity<UserDto> edit(@Valid @RequestBody UserDto userDto){
        userService.update(userMapper.toEntity(userDto));
        return ResponseEntity.ok(userDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@Positive @PathVariable("id") Long id){
        userService.deleteById(id);
        return ResponseEntity.ok("Deleted");
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUser(@Positive @PathVariable("id") long id){
        return ResponseEntity.ok(userDtoDao.getById(id));
    }
}
