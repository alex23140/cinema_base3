package com.kata.cinema.base.models.dto;

import com.kata.cinema.base.models.enums.TypeCharacter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MoviePersonDto {
    private List<String> genres;
    private Map<String, List<PersonInfoDto>> persons;
}
