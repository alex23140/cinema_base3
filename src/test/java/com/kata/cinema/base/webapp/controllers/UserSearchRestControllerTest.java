package com.kata.cinema.base.webapp.controllers;

import com.github.springtestdbunit.annotation.DatabaseOperation;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.DatabaseTearDown;
import com.kata.cinema.base.webapp.CinemaBaseApplicationTests;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class UserSearchRestControllerTest extends CinemaBaseApplicationTests {


    // получтить SearchDto по умолчанию
    @Test
    @DatabaseSetup(value = {
            "/dataset/UserSearchRestController/movie.xml",
            "/dataset/UserSearchRestController/person.xml"
    },
            type = DatabaseOperation.CLEAN_INSERT)
    @DatabaseTearDown(value = {
            "/dataset/UserSearchRestController/movie.xml",
            "/dataset/UserSearchRestController/person.xml",
    },
            type = DatabaseOperation.DELETE_ALL)
    public void shouldGetSearchDto() throws Exception {

        this.mockMvc.perform(get("/api/search/"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.movies[0].id").value(100))
                .andExpect(MockMvcResultMatchers.jsonPath("$.movies[1].id").value(101))
                .andExpect(MockMvcResultMatchers.jsonPath("$.movies[2].id").value(102))
                .andExpect(MockMvcResultMatchers.jsonPath("$.movies.length()").value(3))
                .andExpect(MockMvcResultMatchers.jsonPath("$.persons[0].id").value(100))
                .andExpect(MockMvcResultMatchers.jsonPath("$.persons[1].id").value(101))
                .andExpect(MockMvcResultMatchers.jsonPath("$.persons[2].id").value(102))
                .andExpect(MockMvcResultMatchers.jsonPath("$.persons.length()").value(3));
    }


    // получтить SearchDto по limit
    @Test
    @DatabaseSetup(value = {
            "/dataset/UserSearchRestController/movie.xml",
            "/dataset/UserSearchRestController/person.xml"
    },
            type = DatabaseOperation.CLEAN_INSERT)
    @DatabaseTearDown(value = {
            "/dataset/UserSearchRestController/movie.xml",
            "/dataset/UserSearchRestController/person.xml",
    },
            type = DatabaseOperation.DELETE_ALL)
    public void shouldGetSearchDtoWithLimit() throws Exception {
        this.mockMvc.perform(get("/api/search/4"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.movies.length()").value(4))
                .andExpect(MockMvcResultMatchers.jsonPath("$.persons.length()").value(4));
    }


    // получтить SearchDto по не полному имени movie
    @Test
    @DatabaseSetup(value = {
            "/dataset/UserSearchRestController/movie.xml",
            "/dataset/UserSearchRestController/person.xml"
    },
            type = DatabaseOperation.CLEAN_INSERT)
    @DatabaseTearDown(value = {
            "/dataset/UserSearchRestController/movie.xml",
            "/dataset/UserSearchRestController/person.xml",
    },
            type = DatabaseOperation.DELETE_ALL)
    public void shouldGetSearchDtoNntFullName() throws Exception {
        this.mockMvc.perform(get("/api/search/notFullName/movie"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.jsonPath("$.[0].length()").value(5));
    }


    // получтить SearchDto по не полному имени 101
    @Test
    @DatabaseSetup(value = {
            "/dataset/UserSearchRestController/movie.xml",
            "/dataset/UserSearchRestController/person.xml"
    },
            type = DatabaseOperation.CLEAN_INSERT)
    @DatabaseTearDown(value = {
            "/dataset/UserSearchRestController/movie.xml",
            "/dataset/UserSearchRestController/person.xml",
    },
            type = DatabaseOperation.DELETE_ALL)
    public void shouldGetSearchDtoNntFullName2() throws Exception {
        this.mockMvc.perform(get("/api/search/notFullName/101"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.jsonPath("$.[0].name").value("movie101"));
    }
}
