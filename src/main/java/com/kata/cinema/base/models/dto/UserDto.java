package com.kata.cinema.base.models.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;


import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    @NotBlank
    private Long id;
    @NotBlank
    private String email;
    @NotBlank
    private String nickname;
    private String firstName;
    private String lastName;
    private String password;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy")
    private LocalDate birthday;
}
