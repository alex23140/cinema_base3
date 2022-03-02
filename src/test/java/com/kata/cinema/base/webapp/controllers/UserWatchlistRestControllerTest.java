package com.kata.cinema.base.webapp.controllers;

import com.github.springtestdbunit.annotation.DatabaseOperation;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.DatabaseTearDown;
import com.kata.cinema.base.dao.impl.dto.WatchlistDtoDaoImpl;
import com.kata.cinema.base.models.dto.WatchlistDto;
import com.kata.cinema.base.webapp.CinemaBaseApplicationTests;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import javax.persistence.NoResultException;
import java.util.Optional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class UserWatchlistRestControllerTest extends CinemaBaseApplicationTests {


    @Test
    @DatabaseSetup(value = {
            "/dataset/UserWatchlistRestController/roles.xml",
            "/dataset/UserWatchlistRestController/users.xml",
            "/dataset/UserWatchlistRestController/watchlist.xml"
    },
            type = DatabaseOperation.CLEAN_INSERT)
    @DatabaseTearDown(value = {
            "/dataset/UserWatchlistRestController/roles.xml",
            "/dataset/UserWatchlistRestController/users.xml",
            "/dataset/UserWatchlistRestController/watchlist.xml"
    },
            type = DatabaseOperation.DELETE_ALL)
    public void shouldReturnWatchlist() throws Exception {
        this.mockMvc.perform(get("/api/user/watchlist/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.category").value("FAVORITE_MOVIES"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.privacy").value("PRIVATE"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("MY_LIST"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.description").value("FAVORITE_MOVIES"));
    }

    @Test
    @DatabaseSetup(value = {
            "/dataset/UserWatchlistRestController/roles.xml",
            "/dataset/UserWatchlistRestController/users.xml",
            "/dataset/UserWatchlistRestController/watchlist.xml"
    },
            type = DatabaseOperation.CLEAN_INSERT)
    @DatabaseTearDown(value = {
            "/dataset/UserWatchlistRestController/roles.xml",
            "/dataset/UserWatchlistRestController/users.xml",
            "/dataset/UserWatchlistRestController/watchlist.xml"
    },
            type = DatabaseOperation.DELETE_ALL)
    public void shouldReturnWatchlistError() throws Exception {
        this.mockMvc.perform(get("/api/user/watchlist/200"))
                .andExpect(status().is5xxServerError());
    }

    @Test
    @DatabaseSetup(value = {
            "/dataset/UserWatchlistRestController/roles.xml",
            "/dataset/UserWatchlistRestController/users.xml",
            "/dataset/UserWatchlistRestController/watchlist.xml"
    },
            type = DatabaseOperation.CLEAN_INSERT)
    @DatabaseTearDown(value = {
            "/dataset/UserWatchlistRestController/roles.xml",
            "/dataset/UserWatchlistRestController/users.xml",
            "/dataset/UserWatchlistRestController/watchlist.xml"
    },
            type = DatabaseOperation.DELETE_ALL)
    public void givenWatchlist_whenAdd_thenStatus400andWatchlistReturned() throws Exception {

        Optional<WatchlistDto> watchlistDtoNew = watchlistDtoDao.findWatchlistDtoById(1L);
        watchlistDtoNew.get().setId(null);

        this.mockMvc.perform(
                        post("/api/user/watchlist/")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(watchlistDtoNew.get())))
                .andExpect(status().isBadRequest());
    }

    @Test
    @DatabaseSetup(value = {
            "/dataset/UserWatchlistRestController/roles.xml",
            "/dataset/UserWatchlistRestController/users.xml",
            "/dataset/UserWatchlistRestController/watchlist.xml"
    },
            type = DatabaseOperation.CLEAN_INSERT)
    @DatabaseTearDown(value = {
            "/dataset/UserWatchlistRestController/roles.xml",
            "/dataset/UserWatchlistRestController/users.xml",
            "/dataset/UserWatchlistRestController/watchlist.xml"
    },
            type = DatabaseOperation.DELETE_ALL)
    public void givenWatchlist_whenPut_thenStatus400andWatchlistReturned() throws Exception {

        Optional<WatchlistDto> watchlistDto = watchlistDtoDao.findWatchlistDtoById(1L);

        this.mockMvc.perform(
                        put("/api/user/watchlist")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(watchlistDto.get()))
                )
                .andExpect(status().isBadRequest());
    }

    public Optional<WatchlistDto> findWatchlistDtoById(Long id) {
        try {
            return Optional.of(entityManager.createQuery("""
                            SELECT NEW com.kata.cinema.base.models.dto.WatchlistDto(
                            w.id,
                            w.category,
                            w.privacy,
                            w.name,
                            w.description,
                            w.user.id)
                            FROM Watchlist w where w.id = :id""", WatchlistDto.class)
                    .setParameter("id", id)
                    .getSingleResult());
        } catch (NoResultException e) {
            return Optional.empty();
        }
    }

}

