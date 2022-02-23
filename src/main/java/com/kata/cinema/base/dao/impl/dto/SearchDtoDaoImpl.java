package com.kata.cinema.base.dao.impl.dto;

import com.kata.cinema.base.dao.abstracts.dto.SearchDtoDao;
import com.kata.cinema.base.models.dto.SearchDto;
import com.kata.cinema.base.models.dto.SearchMovieDto;
import com.kata.cinema.base.models.dto.SearchPersonDto;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class SearchDtoDaoImpl implements SearchDtoDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<SearchMovieDto> getFastSearchMovieDto(String notFullName) {
        List<SearchMovieDto> searchMovies = new ArrayList<>();

        List<SearchMovieDto> movies = entityManager.createQuery("""
                select new com.kata.cinema.base.models.dto.SearchMovieDto(
                u.id,
                u.name,
                u.originName,
                u.dateRelease,
                u.previewIsExist
                )from  Movie u """, SearchMovieDto.class).getResultList();

        for(SearchMovieDto movie : movies ) {
            if (movie.getName().toLowerCase(Locale.ROOT).contains(notFullName.toLowerCase(Locale.ROOT))){
                searchMovies.add(movie);
            }
        }
        return searchMovies;
    }

    @Override
    public Optional<SearchDto> getSearchDto(int limit) {
        List<SearchMovieDto> searchMovies = findSearchMovieDto(limit);
        List<SearchPersonDto> searchPersons = findSearchPersonDto(limit);
        SearchDto searchDto = new SearchDto(searchMovies, searchPersons);
        return Optional.of(searchDto);
    }

    private List<SearchMovieDto> findSearchMovieDto(int limit) {
        return entityManager.createQuery("""                        
                        SELECT NEW com.kata.cinema.base.models.dto.SearchMovieDto(
                        w.id,
                        w.name,
                        w.originName,
                        w.dateRelease,
                        w.previewIsExist) FROM Movie w """, SearchMovieDto.class)
                .getResultList().stream().limit(limit).collect(Collectors.toList());
    }

    private List<SearchPersonDto> findSearchPersonDto(int limit) {
        return entityManager.createQuery("""                        
                        SELECT NEW com.kata.cinema.base.models.dto.SearchPersonDto(
                        w.id,
                        concat(w.firstName , ' ', w.lastName), 
                        concat(w.originFirstName , ' ', w.originLastName),
                        w.birthday,
                        w.avatarIsExist) FROM Person w """, SearchPersonDto.class)
                .getResultList().stream().limit(limit).collect(Collectors.toList());
    }
}
