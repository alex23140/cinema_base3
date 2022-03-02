package com.kata.cinema.base.webapp.controllers;

import com.github.springtestdbunit.annotation.DatabaseOperation;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.DatabaseTearDown;
import com.jayway.jsonpath.JsonPath;
import com.kata.cinema.base.models.dto.MovieDto;
import com.kata.cinema.base.webapp.CinemaBaseApplicationTests;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class ModeratorMovieRestControllerTest extends CinemaBaseApplicationTests {

    @Test
    @DatabaseSetup(value = {
            "/dataset/ModeratorMovieRestController/movies.xml",
            "/dataset/ModeratorMovieRestController/genres.xml",
            "/dataset/ModeratorMovieRestController/persons.xml",
            "/dataset/ModeratorMovieRestController/professions.xml",
            "/dataset/ModeratorMovieRestController/movies_genres.xml",
            "/dataset/ModeratorMovieRestController/movie_person.xml",
            "/dataset/ModeratorMovieRestController/movie_person_to_profession.xml"},
            type = DatabaseOperation.CLEAN_INSERT)
    @DatabaseTearDown(value = {
            "/dataset/ModeratorMovieRestController/movies.xml",
            "/dataset/ModeratorMovieRestController/genres.xml",
            "/dataset/ModeratorMovieRestController/persons.xml",
            "/dataset/ModeratorMovieRestController/professions.xml",
            "/dataset/ModeratorMovieRestController/movies_genres.xml",
            "/dataset/ModeratorMovieRestController/movie_person.xml",
            "/dataset/ModeratorMovieRestController/movie_person_to_profession.xml"},
            type = DatabaseOperation.DELETE_ALL)
    public void shouldReturnMovie() throws Exception {
        this.mockMvc.perform(get("/api/moderator/movie/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("movie2"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.country").value("rus2"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.dateRelease").value("10.10.2020"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.description").value("test2"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.mpaa").value("PARENTAL_GUIDANCE_SUGGESTED"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.previewIsExist").value("true"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.rars").value("SIX_PLUS"))
                .andExpect((MockMvcResultMatchers.jsonPath("$.genres", Matchers.containsInAnyOrder("Драма", "Ужасы"))))
                .andExpect((MockMvcResultMatchers.jsonPath("$.persons", Matchers.hasKey("Актер"))))
                .andExpect((MockMvcResultMatchers.jsonPath("$.persons", Matchers.hasKey("Сценарист"))));
  }

    @Test
    @DatabaseTearDown(value = "/dataset/ModeratorMovieRestController/movies.xml", type = DatabaseOperation.DELETE_ALL)
    public void shouldCreateMovie() throws Exception {
        //создаем
        MovieDto movieDto = new MovieDto();
        movieDto.setName("movie1");

        //постим
        int id = JsonPath.read(this.mockMvc.perform(post("/api/moderator/movie")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(movieDto)))
                .andExpect(status().isCreated())
                .andReturn().getResponse().getContentAsString(), "$.id");

        //проверяем, что запостилось
        int count = ((Number) entityManager.createQuery("SELECT COUNT(m) FROM Movie m WHERE m.id = :id")
                .setParameter("id", (long) id)
                .getSingleResult())
                .intValue();
        assertTrue(count > 0);
    }
}

