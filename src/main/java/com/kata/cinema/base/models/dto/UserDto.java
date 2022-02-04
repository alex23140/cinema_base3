package com.kata.cinema.base.models.dto;

import lombok.*;


import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    @NotBlank
    Long id;
    @NotBlank
    String email;
    @NotBlank
    String nickname;
    String firstName;
    String lastName;
    String password;
    LocalDate birthday;
}
