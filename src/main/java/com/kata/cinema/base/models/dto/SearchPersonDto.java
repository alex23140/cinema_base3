package com.kata.cinema.base.models.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SearchPersonDto {
    private Long id;
    private String fullName;
    private String originFullName;
    private LocalDate birthday;
    private Boolean avatarIsExist;
}