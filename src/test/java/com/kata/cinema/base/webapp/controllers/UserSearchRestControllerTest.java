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

    // получтить SearchDto по неполному имени и дефолтному значению лимита
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
    public void shouldGetSearchDtoWithDefLimit() throws Exception {
        this.mockMvc.perform(get("/api/search/notFullName?notFullName=100"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.jsonPath("$.movies.length()").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.persons.length()").value(1));
    }

    // получтить SearchDto по неполному имени и лимиту
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
        this.mockMvc.perform(get("/api/search/notFullName?notFullName=movie&limit=3"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.jsonPath("$.movies.length()").value(3))
                .andExpect(MockMvcResultMatchers.jsonPath("$.persons.length()").value(0));
    }
}
