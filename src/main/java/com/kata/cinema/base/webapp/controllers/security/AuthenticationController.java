package com.kata.cinema.base.webapp.controllers.security;

import com.kata.cinema.base.mapper.UserRegistrationMapper;
import com.kata.cinema.base.models.dto.UserRegistrationDto;
import com.kata.cinema.base.service.abstracts.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@AllArgsConstructor
public class AuthenticationController {

    private final UserService userService;
    private final UserRegistrationMapper userRegistrationMapper;

    @PostMapping(value = "/api/registration")
    public ResponseEntity<UserRegistrationDto> create(@RequestBody UserRegistrationDto userRegistrationDto){
        userService.create(userRegistrationMapper.toEntity(userRegistrationDto));
        return new ResponseEntity<>(userRegistrationDto, HttpStatus.CREATED); // HttpStatus.CREATED = 201
    }
}
