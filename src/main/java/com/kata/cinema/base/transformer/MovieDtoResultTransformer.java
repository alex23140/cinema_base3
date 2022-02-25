package com.kata.cinema.base.transformer;

import org.hibernate.transform.ResultTransformer;

import java.util.List;

public class MovieDtoResultTransformer implements ResultTransformer {
    @Override
    public Object transformTuple(Object[] objects, String[] strings) {
        return null;
    }

    @Override
    public List transformList(List list) {
        return null;
    }
}
