package com.kata.cinema.base.webapp.controllers;

import com.github.springtestdbunit.annotation.DatabaseOperation;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.kata.cinema.base.webapp.CinemaBaseApplicationTests;
import org.junit.Test;
import org.springframework.http.MediaType;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class UserWatchlistRestController extends CinemaBaseApplicationTests {

    @Test
    @DatabaseSetup(value = "/dataset/UserWatchlistRestController/role.xml", type = DatabaseOperation.CLEAN_INSERT)
    @DatabaseSetup(value = "/dataset/UserWatchlistRestController/user.xml", type = DatabaseOperation.CLEAN_INSERT)
    @DatabaseSetup(value = "/dataset/UserWatchlistRestController/watchlist.xml", type = DatabaseOperation.CLEAN_INSERT)
    @DatabaseSetup(value = "/dataset/ModeratorMovieRestController/movie.xml", type = DatabaseOperation.CLEAN_INSERT)
    public void shouldAddMovieToList() throws Exception {

        List<Long> ids = new ArrayList<>();
        ids.add(1L);
        ids.add(2L);

        this.mockMvc.perform(post("/api/user/watchlist/1/movies")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(ids)))
                .andExpect(status().isOk());
    }

    @Test
    @DatabaseSetup(value = "/dataset/UserWatchlistRestController/role.xml", type = DatabaseOperation.CLEAN_INSERT)
    @DatabaseSetup(value = "/dataset/UserWatchlistRestController/user.xml", type = DatabaseOperation.CLEAN_INSERT)
    @DatabaseSetup(value = "/dataset/UserWatchlistRestController/watchlist.xml", type = DatabaseOperation.CLEAN_INSERT)
    @DatabaseSetup(value = "/dataset/ModeratorMovieRestController/movie.xml", type = DatabaseOperation.CLEAN_INSERT)
    public void shouldDeleteMovieFromList() throws Exception {

        List<Long> ids = new ArrayList<>();
        ids.add(1L);
        ids.add(2L);

        this.mockMvc.perform(delete("/api/user/watchlist/1/movies")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(ids)))
                .andExpect(status().isOk());
    }
}
