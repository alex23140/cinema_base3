package com.kata.cinema.base.mapper;

import java.util.List;

public interface AbstractMapper<D, E> {
    D toDto(E e);

    E toEntity(D d);

    List<E> toEntity(List<D> dList);

    List<D> toDto(List<? extends E> eList);
}
