package com.kata.cinema.base.models.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserRegistrationDto {
    @NotEmpty
    String email;
    @NotEmpty
    String nickname;
    String firstName;
    String lastName;
    @NotEmpty
    String password;

}
