package com.kata.cinema.base.models.dto;

import lombok.*;

import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"id"})
public class PageDto<T> {
    private Long id;
    Long count;
    List<T> entities;
}

