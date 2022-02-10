package com.kata.cinema.base.webapp;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.kata.cinema.base.webapp.controllers.moderator.ModeratorMovieRestController;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@TestExecutionListeners({
        DependencyInjectionTestExecutionListener.class,
        DbUnitTestExecutionListener.class
})
public class CinemaBaseApplicationTests {
    @Autowired
    protected ObjectMapper objectAsJsonMapper;

    @Autowired
    private ModeratorMovieRestController moderatorMovieRestController;

    @PersistenceContext
    protected EntityManager entityManager;

    @Test
    void contextLoads() {
        assertThat(moderatorMovieRestController).isNotNull();
    }
}
