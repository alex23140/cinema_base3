package com.kata.cinema.base.models.dto;

import com.kata.cinema.base.models.enums.TypeCharacter;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = {"id", "fullName"})
public class PersonMovieDto {
    private Long id;
    //TODO добавить originalFullName в таблицу
    private String fullName;
    private String originalFullName;
    private TypeCharacter type;
    private String nameCharacter;
}
