package com.kata.cinema.base.dao.impl.model;


import com.kata.cinema.base.dao.abstracts.model.MoviePersonInformationDao;
import com.kata.cinema.base.models.entity.MoviePersonInformation;
import org.springframework.stereotype.Repository;


@Repository
public class MoviePersonInformationDaoImpl extends AbstractDaoImpl<Long, MoviePersonInformation> implements MoviePersonInformationDao {
}
