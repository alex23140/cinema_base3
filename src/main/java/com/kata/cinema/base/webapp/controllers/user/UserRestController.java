package com.kata.cinema.base.webapp.controllers.user;

import com.kata.cinema.base.dao.abstracts.dto.UserDtoDao;
import com.kata.cinema.base.mapper.UserMapper;
import com.kata.cinema.base.models.dto.UserDto;
import com.kata.cinema.base.service.abstracts.entity.UserService;
import com.kata.cinema.base.webapp.util.ApiValidationUtils;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/api/user")
@Validated
public class UserRestController {

    private final UserService userService;
    private final UserMapper userMapper;
    //TODO создать сервис
    private final UserDtoDao userDtoDao;

    @ApiOperation(value = "Обновление User", notes = "Обновление User")
    @PutMapping
    public ResponseEntity<UserDto> edit(@Valid @RequestBody UserDto userDto) {
        userService.update(userMapper.toEntity(userDto));
        return ResponseEntity.ok(userDto);
    }

    @ApiOperation(value = "Удаление User по id", notes = "Удаление User по id")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@Positive @PathVariable("id") Long id) {
        userService.deleteById(id);
        return ResponseEntity.ok("Deleted");
    }

    @ApiOperation(value = "Получение User по id", notes = "Получение User по id")
    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUser(@Positive @PathVariable("id") Long id) {
        Optional<UserDto> optionalUserDto = userDtoDao.getById(id);
        ApiValidationUtils.requireTrue(optionalUserDto.isPresent(), "пользователя с таким id не существует");
        return ResponseEntity.ok(optionalUserDto.get());
    }
}
