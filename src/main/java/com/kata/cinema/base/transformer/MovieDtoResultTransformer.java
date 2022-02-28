package com.kata.cinema.base.transformer;

import com.kata.cinema.base.models.dto.MovieDto;
import org.hibernate.transform.ResultTransformer;

import java.util.List;

public class MovieDtoResultTransformer implements ResultTransformer {
    @Override
    public Object transformTuple(Object[] objects, String[] strings) {
        return new MovieDto();
    }

    @Override
    public List transformList(List list) {
        return null;
    }
}
