package com.kata.cinema.base.webapp;

import com.kata.cinema.base.webapp.controllers.moderator.ModeratorMovieRestController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@AutoConfigureMockMvc
class CinemaBaseApplicationTests {
    @Autowired
    private ModeratorMovieRestController moderatorMovieRestController;

    @Test
    void contextLoads() {
        assertThat(moderatorMovieRestController).isNotNull();
    }
}
