package com.kata.cinema_base;

import com.kata.cinema.base.webapp.CinemaBaseApplication;
import com.kata.cinema.base.webapp.controllers.moderator.ModeratorMovieRestController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = CinemaBaseApplication.class)
class CinemaBaseApplicationTests {
    @Autowired
    private ModeratorMovieRestController moderatorMovieRestController;

    @Test
    void contextLoads() {
        assertThat(moderatorMovieRestController).isNotNull();
    }

}
