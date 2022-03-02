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
        MoviePersonFromQuery moviePersonFromQuery = new MoviePersonFromQuery();

        moviePersonFromQuery.setName(objects[0].toString());
        moviePersonFromQuery.setCountry(objects[1].toString());
        moviePersonFromQuery.setDescription(objects[2].toString());
        moviePersonFromQuery.setPreviewIsExist((Boolean) objects[3]);
        moviePersonFromQuery.setDateRelease(LocalDate.parse(objects[4].toString()));
        moviePersonFromQuery.setGenre(objects[5].toString());
        moviePersonFromQuery.setRars((RARS) objects[6]);
        moviePersonFromQuery.setMpaa((MPAA) objects[7]);
        moviePersonFromQuery.setPersonName(objects[8].toString());
        moviePersonFromQuery.setPersonLastname(objects[9].toString());
        moviePersonFromQuery.setPersonOriginalName(objects[10].toString());
        moviePersonFromQuery.setPersonOriginalLastname(objects[11].toString());
        moviePersonFromQuery.setCharacterName(objects[12].toString());
        moviePersonFromQuery.setType((TypeCharacter) objects[13]);
        moviePersonFromQuery.setProfession(objects[14].toString());

        return moviePersonFromQuery;
    }

    @Override
    public List<MoviePersonDto> transformList(List list) {
        List<MoviePersonFromQuery> moviePersonFromQueries = new ArrayList<MoviePersonFromQuery>(list);

        // основная информация о фильме
        MoviePersonDto moviePersonDto = new MoviePersonDto();
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
