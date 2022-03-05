package com.kata.cinema.base.transformer;

import com.kata.cinema.base.models.dto.MoviePersonDto;
import com.kata.cinema.base.models.dto.PersonMovieDto;
import com.kata.cinema.base.models.enums.MPAA;
import com.kata.cinema.base.models.enums.RARS;
import com.kata.cinema.base.models.enums.TypeCharacter;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.transform.ResultTransformer;

import java.time.LocalDate;
import java.util.*;

public class MovieDtoResultTransformer implements ResultTransformer {
    @Override
    public Object transformTuple(Object[] objects, String[] strings) {
        if (objects.length == 0) {
            return null;
        }
        MoviePersonFromQuery moviePersonFromQuery = new MoviePersonFromQuery();

        moviePersonFromQuery.setId(objects[0] != null ? (Long) objects[0] : null);
        moviePersonFromQuery.setName(objects[1] != null ? objects[1].toString() : null);
        moviePersonFromQuery.setCountry(objects[2] != null ? objects[2].toString() : null);
        moviePersonFromQuery.setDescription(objects[3] != null ? objects[3].toString() : null);
        moviePersonFromQuery.setPreviewIsExist(objects[4] != null ? (Boolean) objects[4] : null);
        moviePersonFromQuery.setDateRelease(objects[5] != null ? LocalDate.parse(objects[5].toString()) : null);
        moviePersonFromQuery.setGenre(objects[6] != null ? objects[6].toString() : null);
        moviePersonFromQuery.setRars(objects[7] != null ? (RARS) objects[7] : null);
        moviePersonFromQuery.setMpaa(objects[8] != null ? (MPAA) objects[8] : null);
        moviePersonFromQuery.setPersonLastname(objects[9] != null ? objects[9].toString() : null);
        moviePersonFromQuery.setPersonLastname(objects[10] != null ? objects[10].toString() : null);
        moviePersonFromQuery.setPersonOriginalName(objects[11] != null ? objects[11].toString() : null);
        moviePersonFromQuery.setPersonOriginalLastname(objects[12] != null ? objects[12].toString() : null);
        moviePersonFromQuery.setCharacterName(objects[13] != null ? objects[13].toString() : null);
        moviePersonFromQuery.setType(objects[14] != null ? (TypeCharacter) objects[14] : null);
        moviePersonFromQuery.setProfession(objects[15] != null ? objects[15].toString() : null);

        return moviePersonFromQuery;
    }

    @Override
    public List<MoviePersonDto> transformList(List list) {
        if (list.size() == 0) {
            return Collections.emptyList();
        }
        List<MoviePersonFromQuery> moviePersonFromQueries = new ArrayList<MoviePersonFromQuery>(list);

        // основная информация о фильме
        MoviePersonDto moviePersonDto = new MoviePersonDto();
        moviePersonDto.setId(moviePersonFromQueries.get(0).id);
        moviePersonDto.setName(moviePersonFromQueries.get(0).name);
        moviePersonDto.setCountry(moviePersonFromQueries.get(0).country);
        moviePersonDto.setDescription(moviePersonFromQueries.get(0).description);
        moviePersonDto.setDateRelease(moviePersonFromQueries.get(0).dateRelease);
        moviePersonDto.setRars(moviePersonFromQueries.get(0).rars);
        moviePersonDto.setMpaa(moviePersonFromQueries.get(0).mpaa);
        moviePersonDto.setPreviewIsExist(moviePersonFromQueries.get(0).previewIsExist);

        List<String> genres = new ArrayList<>();
        Map<String, List<PersonMovieDto>> persons = new HashMap<>();
        for (MoviePersonFromQuery moviePersonFromQuery : moviePersonFromQueries) {
            // жанры
            if (!genres.contains(moviePersonFromQuery.genre)) {
                genres.add(moviePersonFromQuery.genre);
            }

            // профессии и персоны
            PersonMovieDto person = new PersonMovieDto();
            person.setFullName(moviePersonFromQuery.personName + " "
                    + moviePersonFromQuery.personLastname);
            person.setOriginalFullName(moviePersonFromQuery.personOriginalName + " "
                    + moviePersonFromQuery.personOriginalLastname);
            person.setType(moviePersonFromQuery.type);
            person.setNameCharacter(moviePersonFromQuery.characterName);

            persons.putIfAbsent(moviePersonFromQuery.profession, new ArrayList<>());
            if (!persons.get(moviePersonFromQuery.profession).contains(person)) {
                persons.get(moviePersonFromQuery.profession).add(person);
            }
        }
        moviePersonDto.setGenres(genres);
        moviePersonDto.setPersons(persons);

        return Collections.singletonList(moviePersonDto);

    }

    @Getter
    @Setter
    private static class MoviePersonFromQuery {
        private Long id;
        private String name;
        private String country;
        private String description;
        private Boolean previewIsExist;
        private LocalDate dateRelease;
        private String genre;
        private RARS rars;
        private MPAA mpaa;
        private String personName;
        private String personLastname;
        private String personOriginalName;
        private String personOriginalLastname;
        private String characterName;
        private TypeCharacter type;
        private String profession;
    }
}
