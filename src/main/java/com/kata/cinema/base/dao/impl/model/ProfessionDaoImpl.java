package com.kata.cinema.base.dao.impl.model;

import com.kata.cinema.base.dao.abstracts.model.ProfessionDao;
import com.kata.cinema.base.models.entity.Profession;
import org.springframework.stereotype.Repository;

@Repository
public class ProfessionDaoImpl extends AbstractDaoImpl<Long, Profession> implements ProfessionDao {
}
