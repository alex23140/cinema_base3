package com.kata.cinema.base.webapp.config;

import com.kata.cinema.base.models.entity.*;
import com.kata.cinema.base.service.abstracts.entity.WatchlistService;
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
import java.util.ArrayList;
import java.util.List;

import static com.kata.cinema.base.models.enums.Category.*;
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

    private final long NUM_OF_USERS = 10L;
    private List<User> users = new ArrayList<>();

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
        role1.setName("ROLE_ADMIN");
        roleService.update(role1);

        Role role2 = new Role();

        role2.setId(2L);
        role2.setName("ROLE_USER");
        roleService.update(role2);
    }

    public void addUser() {
        Role role1 = roleService.getRoleByName("ROLE_ADMIN");
        Role role2 = roleService.getRoleByName("ROLE_USER");

        for (Long i = 1L; i <= NUM_OF_USERS; i++) {
            User user1 = new User();
            user1.setRole(role1);
            user1.setId(i);
            user1.setEmail("user" + i + "@mail.ru");
            user1.setNickname("user" + i);
            user1.setFirstName("user" + i +"Firstname");
            user1.setLastName("user"+ i +"Lastname");
            user1.setPassword("user111111111111");
            user1.setBirthday(LocalDate.of(1995, 11, 12));
            user1.setEnabled(true);
            users.add(user1);
            userService.update(user1);
        }

        for (Long i =NUM_OF_USERS+1; i <= NUM_OF_USERS*2; i++) {
            User user2 = new User();
            user2.setRole(role2);
            user2.setId(i);
            user2.setEmail("user" + i + "@mail.ru");
            user2.setNickname("user" + i);
            user2.setFirstName("user" + i +"Firstname");
            user2.setLastName("user"+ i +"Lastname");
            user2.setPassword("user111111111111");
            user2.setBirthday(LocalDate.of(1995, 11, 12));
            user2.setEnabled(true);
            users.add(user2);
            userService.update(user2);
        }
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
        Watchlist watchlist2 = new Watchlist();
        Watchlist watchlist3 = new Watchlist();

        for (int i=3 ; i<=users.size()-1 ; i++) {
            watchlist1.setUser(users.get(i));
            watchlist1.setCategory(WAITING_MOVIES);
            watchlist1.setPrivacy(PUBLIC);
            watchlist1.setName("watchlist"+ i);
            watchlist1.setDescription("description1");
            watchlistService.update(watchlist1);

            watchlist2.setUser(users.get(i));
            watchlist2.setCategory(FAVORITE_MOVIES);
            watchlist2.setPrivacy(PUBLIC);
            watchlist2.setName("watchlist" + ((users.size())+i));
            watchlist2.setDescription("description1");
            watchlistService.update(watchlist2);

            watchlist3.setUser(users.get(i));
            watchlist3.setCategory(WILL_WATCH);
            watchlist3.setPrivacy(PUBLIC);
            watchlist3.setName("watchlist" + ((users.size()*2)+i));
            watchlist3.setDescription("description1");
            watchlistService.update(watchlist3);
        }
    }
}
