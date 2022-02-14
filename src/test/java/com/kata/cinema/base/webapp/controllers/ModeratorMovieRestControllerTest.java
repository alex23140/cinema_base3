package com.kata.cinema.base.webapp.controllers;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
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

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
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

    @Test
    @DatabaseSetup("/dataset/movie.xml")
    public void shouldReturnMovie() throws Exception {
        this.mockMvc.perform(get("/api/moderator/movie/2"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(2))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("movie2"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.country").value("rus2"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.dateRelease").value("10.10.2020"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.description").value("test2"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.mpaa").value("PARENTS_STRONGLY_CAUTIONED"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.previewIsExist").value("true"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.rars").value("TWELVE_PLUS"));
    }
}
