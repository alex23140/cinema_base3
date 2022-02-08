package com.kata.cinema.base.models.dto;

import com.kata.cinema.base.models.enums.Rubric;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NewsDto {

    private Long id;
    private Rubric rubric;
    public LocalDateTime date;
    private String title;
    private String description;
}
