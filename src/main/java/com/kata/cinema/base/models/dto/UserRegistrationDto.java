package com.kata.cinema.base.models.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserRegistrationDto {
    @NotBlank
    private String email;
    @NotBlank
    private String nickname;
    private String firstName;
    private String lastName;
    @NotBlank
    private String password;
}
