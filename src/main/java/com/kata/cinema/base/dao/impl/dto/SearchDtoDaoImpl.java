package com.kata.cinema.base.dao.impl.dto;

import com.kata.cinema.base.dao.abstracts.dto.SearchDtoDao;
import com.kata.cinema.base.models.dto.SearchMovieDto;
import com.kata.cinema.base.models.dto.SearchPersonDto;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class SearchDtoDaoImpl implements SearchDtoDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<SearchMovieDto> getFastSearchMovieDto(String notFullName, int limit) {
        List<SearchMovieDto> movies = entityManager.createQuery("""
                        select new com.kata.cinema.base.models.dto.SearchMovieDto(
                        u.id,
                        u.name,
                        u.originName,
                        u.dateRelease,
                        u.previewIsExist,
                        :notFullName
                        )from  Movie u where u.name LIKE :notFullName or u.originName LIKE :notFullName""", SearchMovieDto.class)
                .setParameter("notFullName", "%" + notFullName + "%")
                .getResultList().stream().limit(limit).collect(Collectors.toList());
        return movies;
    }

    @Override
    public List<SearchPersonDto> getFastSearchPersonDto(String notFullName, int limit) {
        List<SearchPersonDto> person = entityManager.createQuery("""                        
                        SELECT NEW com.kata.cinema.base.models.dto.SearchPersonDto(
                        w.id,
                        concat(w.firstName , ' ', w.lastName), 
                        concat(w.originFirstName , ' ', w.originLastName),
                        w.birthday,
                        w.avatarIsExist,
                        :notFullName
                        ) FROM Person w where concat(w.firstName , ' ', w.lastName) LIKE :notFullName or concat(w.originFirstName , ' ', w.originLastName) LIKE :notFullName""", SearchPersonDto.class)
                .setParameter("notFullName", "%" + notFullName + "%")
                .getResultList().stream().limit(limit).collect(Collectors.toList());
        return person;
    }
}
