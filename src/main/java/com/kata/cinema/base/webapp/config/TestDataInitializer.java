package com.kata.cinema.base.webapp.config;

import com.kata.cinema.base.models.entity.*;
import com.kata.cinema.base.service.abstracts.WatchlistService;
import com.kata.cinema.base.service.abstracts.entity.MovieService;
import com.kata.cinema.base.service.abstracts.entity.NewsService;
import com.kata.cinema.base.service.abstracts.entity.RoleService;
import com.kata.cinema.base.service.abstracts.entity.UserService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static com.kata.cinema.base.models.enums.Category.WAITING_MOVIES;
import static com.kata.cinema.base.models.enums.MPAA.PARENTAL_GUIDANCE_SUGGESTED;
import static com.kata.cinema.base.models.enums.Privacy.PUBLIC;
import static com.kata.cinema.base.models.enums.RARS.TWELVE_PLUS;
import static com.kata.cinema.base.models.enums.Rubric.ABOUT_CINEMA;

@Component
@ConditionalOnExpression("'${spring.jpa.hibernate.ddl-auto}'=='create'")
public class TestDataInitializer {

    private final RoleService roleService;
    private final UserService userService;
    private final MovieService movieService;
    private final NewsService newsService;
    private final WatchlistService watchlistService;

    public TestDataInitializer(RoleService roleService, UserService userService, MovieService movieService, NewsService newsService, WatchlistService watchlistService) {
        this.roleService = roleService;
        this.userService = userService;
        this.movieService = movieService;
        this.newsService = newsService;
        this.watchlistService = watchlistService;
    }

    @PostConstruct
    public void init() {
        addRole();
        addUser();
        addMovie();
        addNews();
        addWatchlist();
    }

    public void addRole() {
        Role role1 = new Role();

        role1.setId(1L);
        role1.setName("Admin");
        roleService.update(role1);

        Role role2 = new Role();

        role2.setId(2L);
        role2.setName("User");
        roleService.update(role2);
    }

    public void addUser() {
        Role adminRole = roleService.getById(1L).get();
        Role userRole = roleService.getById(2L).get();

        User user1 = new User();

        user1.setRole(adminRole);
        user1.setId(3L);
        user1.setEmail("user1@mail.ru");
        user1.setNickname("user1");
        user1.setFirstName("user1Firstname");
        user1.setLastName("user1Lastname");
        user1.setPassword("user111111111111111");
        user1.setBirthday(LocalDate.of(1995, 11, 12));
        user1.setEnabled(true);
        userService.update(user1);

        User user2 = new User();

        user2.setRole(userRole);
        user2.setId(4L);
        user2.setEmail("user2@mail.ru");
        user2.setNickname("user2");
        user2.setFirstName("user2Firstname");
        user2.setLastName("user2Lastname");
        user2.setPassword("user111111111111111");
        user2.setBirthday(LocalDate.of(1997, 1, 3));
        user2.setEnabled(true);
        userService.update(user2);
    }

    public void addMovie() {
        Movie movie1 = new Movie();

        movie1.setId(1L);
        movie1.setName("movie1");
        movie1.setCountry("country1");
        movie1.setDateRelease(LocalDate.of(2000, 2, 7));
        movie1.setRars(TWELVE_PLUS);
        movie1.setMpaa(PARENTAL_GUIDANCE_SUGGESTED);
        movie1.setDescription("description1");
        movie1.setPreviewIsExist(false);
        movieService.update(movie1);
    }

    public void addNews() {
        News news1 = new News();

        news1.setId(1L);
        news1.setRubric(ABOUT_CINEMA);
        news1.setDate(LocalDateTime.of(LocalDate.of(2022, 1, 12), LocalTime.of(12, 21, 12)));
        news1.setTitle("title1");
        news1.setDescription("description1");
        newsService.update(news1);
    }

    public void addWatchlist() {
        Watchlist watchlist1 = new Watchlist();

        watchlist1.setUser(userService.getById(3L).get());
        watchlist1.setId(1L);
        watchlist1.setCategory(WAITING_MOVIES);
        watchlist1.setPrivacy(PUBLIC);
        watchlist1.setName("watchlist1");
        watchlist1.setDescription("description1");
        watchlistService.update(watchlist1);
    }
}
