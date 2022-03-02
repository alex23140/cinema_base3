package com.kata.cinema.base.service.impl.entity;

import com.kata.cinema.base.dao.abstracts.model.AbstractDao;
import com.kata.cinema.base.dao.abstracts.model.MoviePersonInformationDao;

import com.kata.cinema.base.models.entity.MoviePersonInformation;
import com.kata.cinema.base.service.abstracts.entity.MoviePersonInformationService;
import org.springframework.stereotype.Service;

@Service
public class MoviePersonInformationServiceImpl extends AbstractServiceImpl<Long, MoviePersonInformation> implements MoviePersonInformationService {

    private final MoviePersonInformationDao moviePersonInformationDao;

    protected MoviePersonInformationServiceImpl(AbstractDao<Long, MoviePersonInformation> abstractDao, MoviePersonInformationDao moviePersonInformationDao) {
        super(abstractDao);
        this.moviePersonInformationDao = moviePersonInformationDao;
    }
}
