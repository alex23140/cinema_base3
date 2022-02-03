package com.kata.cinema.base.models.dto;

import lombok.*;

import javax.persistence.Entity;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    @NotEmpty
    Long id;
    @NotEmpty
    String email;
    @NotEmpty
    String nickname;
    String firstName;
    String lastName;
    String password;
    LocalDate birthday;
}
