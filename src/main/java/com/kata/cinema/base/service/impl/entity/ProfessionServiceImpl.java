package com.kata.cinema.base.service.impl.entity;

import com.kata.cinema.base.dao.abstracts.model.AbstractDao;
import com.kata.cinema.base.dao.abstracts.model.ProfessionDao;
import com.kata.cinema.base.models.entity.Profession;
import com.kata.cinema.base.service.abstracts.entity.ProfessionService;
import org.springframework.stereotype.Service;

@Service
public class ProfessionServiceImpl  extends AbstractServiceImpl<Long, Profession> implements ProfessionService {

    private final ProfessionDao professionDao;

    protected ProfessionServiceImpl(AbstractDao<Long, Profession> abstractDao, ProfessionDao professionDao) {
        super(abstractDao);
        this.professionDao = professionDao;
    }
}
