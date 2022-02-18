package com.kata.cinema.base.models.dto;

import com.kata.cinema.base.models.enums.TypeCharacter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PersonInfoDto {
    private Long id;
    private String fullName; //конкатенировать
    private String originalFullName;
    private TypeCharacter type;
    private String nameCharacter;
}
