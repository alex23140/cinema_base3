package com.kata.cinema.base.models.dto;

import lombok.*;

import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PageDto<T> {
    Long count;
    List<T> entities;
}

