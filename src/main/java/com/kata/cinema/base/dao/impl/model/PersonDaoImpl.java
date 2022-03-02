package com.kata.cinema.base.dao.impl.model;

import com.kata.cinema.base.dao.abstracts.model.PersonDao;
import com.kata.cinema.base.models.entity.Person;
import org.springframework.stereotype.Repository;


@Repository
public class PersonDaoImpl extends AbstractDaoImpl<Long, Person> implements PersonDao {
}
