package com.kata.cinema.base.webapp.controllers.security;

import com.kata.cinema.base.mapper.UserRegistrationMapper;
import com.kata.cinema.base.models.dto.UserRegistrationDto;
import com.kata.cinema.base.models.entity.User;
import com.kata.cinema.base.service.abstracts.entity.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@RequestMapping("/api")
@Validated
@AllArgsConstructor
public class AuthenticationController {

    private final UserService userService;
    private final UserRegistrationMapper userRegistrationMapper;

    @PostMapping("/registration")
    public ResponseEntity<UserRegistrationDto> create(@Valid @RequestBody UserRegistrationDto userRegistrationDto){
        User user = userRegistrationMapper.toEntity(userRegistrationDto);
        userService.create(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(userRegistrationMapper.toDto(user));
    }
}
