package com.kata.cinema.base.service.impl.entity;


import com.kata.cinema.base.dao.abstracts.model.AbstractDao;
import com.kata.cinema.base.dao.abstracts.model.PersonDao;
import com.kata.cinema.base.models.entity.Person;
import com.kata.cinema.base.service.abstracts.entity.PersonService;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl extends AbstractServiceImpl<Long, Person> implements PersonService {

    private final PersonDao personDao;

    protected PersonServiceImpl(AbstractDao<Long, Person> abstractDao, PersonDao personDao) {
        super(abstractDao);
        this.personDao = personDao;
    }
}
