package com.kata.cinema.base.mapper;

import java.util.List;

public interface DtoMapper<D, E> {
    D toDto(E e);

    List<D> toDto(List<? extends E> eList);
}
