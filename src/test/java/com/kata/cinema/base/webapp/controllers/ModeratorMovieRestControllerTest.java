package com.kata.cinema.base.webapp.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseOperation;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.DatabaseTearDown;
import com.jayway.jsonpath.JsonPath;
import com.kata.cinema.base.models.dto.MovieDto;
import com.kata.cinema.base.models.enums.MPAA;
import com.kata.cinema.base.models.enums.RARS;
import com.kata.cinema.base.service.abstracts.dto.MovieDtoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@RunWith(SpringJUnit4ClassRunner.class)
@TestExecutionListeners({
        DependencyInjectionTestExecutionListener.class,
        DbUnitTestExecutionListener.class
})
public class ModeratorMovieRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private MovieDtoService movieDtoService;

    @Test
    @DatabaseSetup(value = "/dataset/movie.xml", type = DatabaseOperation.CLEAN_INSERT)
    @DatabaseTearDown(value = "/dataset/movie.xml", type = DatabaseOperation.DELETE_ALL)
    public void shouldReturnMovie() throws Exception {
        this.mockMvc.perform(get("/api/moderator/movie/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("movie2"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.country").value("rus2"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.dateRelease").value("10.10.2020"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.description").value("test2"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.mpaa").value("PARENTS_STRONGLY_CAUTIONED"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.previewIsExist").value("true"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.rars").value("TWELVE_PLUS"));
    }

    @Test
    @DatabaseTearDown(value = "/dataset/movie.xml", type = DatabaseOperation.DELETE_ALL)
    public void shouldCreateMovie() throws Exception {
        //создаем сущность (без id)
        MovieDto movieDto = new MovieDto();
        movieDto.setName("movie1");
        movieDto.setCountry("rus1");
        movieDto.setDateRelease(LocalDate.of(2020, 10, 10));
        movieDto.setDescription("test1");
        movieDto.setRars(RARS.EIGHTEEN_PLUS);
        movieDto.setMpaa(MPAA.GENERAL_AUDIENCES);
        movieDto.setPreviewIsExist(true);
        String movieAsJson = getMovieAsJson(movieDto);

        //постим сущность и получаем ее id
        int id = JsonPath.read(this.mockMvc.perform(post("/api/moderator/movie")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(movieAsJson))
                .andExpect(status().isCreated())
                .andReturn().getResponse().getContentAsString(), "$.id");

        //сравниваем отправленную и полученную сущности
        movieDto.setId((long) id);
        MovieDto movieFromDb = movieDtoService.getById((long) id);
        assertThat(movieDto)
                .usingRecursiveComparison()
                .isEqualTo(movieFromDb);
    }

    private String getMovieAsJson(MovieDto movieDto) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        return mapper.writeValueAsString(movieDto);
    }
}

