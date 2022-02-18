package com.kata.cinema.base.webapp.configs;

import com.kata.cinema.base.models.entity.*;
import com.kata.cinema.base.models.enums.Category;
import com.kata.cinema.base.models.enums.MPAA;
import com.kata.cinema.base.models.enums.RARS;
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
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static com.kata.cinema.base.models.enums.Privacy.PUBLIC;
import static com.kata.cinema.base.models.enums.Rubric.ABOUT_CINEMA;

@Component
@ConditionalOnExpression("'${spring.jpa.hibernate.ddl-auto}'=='create'")
public class TestDataInitializer {

    private final RoleService roleService;
    private final UserService userService;
    private final MovieService movieService;
    private final NewsService newsService;
    private final WatchlistService watchlistService;

    private final Random random = new Random(System.currentTimeMillis());
    private static final int COUNT_USERS = 10;
    private static final int COUNT_ADMINS = 2;
    private static final int COUNT_MOVIE = 20;

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
    }

    public void addRole() {
        Role roleAdmin = new Role();
        roleAdmin.setName("ADMIN");
        roleService.create(roleAdmin);

        Role roleUser = new Role();
        roleUser.setName("USER");
        roleService.create(roleUser);
    }

    public void addUser() {
        Role roleAdmin = roleService.getRoleByName("ADMIN");
        Role roleUser = roleService.getRoleByName("USER");
        List<User> users = new ArrayList<>();

        for (int i = 1; i <= COUNT_USERS; i++) {
            User user = new User();
            user.setRole(roleUser);
            user.setEmail("user" + i + "@mail.ru");
            user.setNickname("user" + i);
            user.setFirstName("Имя" + i);
            user.setLastName("Фамилия"+ i);
            user.setPassword("user");
            user.setBirthday(LocalDate.of(1995, 11, 12));
            user.setEnabled(true);
            users.add(user);
            userService.create(user);
        }

        for (int i = 1; i <= COUNT_ADMINS; i++) {
            User admin = new User();
            admin.setRole(roleAdmin);
            admin.setEmail("admin" + i + "@mail.ru");
            admin.setNickname("admin" + i);
            admin.setFirstName("Имя" + i);
            admin.setLastName("Фамилия"+ i);
            admin.setPassword("admin");
            admin.setBirthday(LocalDate.of(1995, 11, 12));
            admin.setEnabled(true);
            users.add(admin);
            userService.create(admin);
        }
        addWatchlist(users);
    }

    public void addMovie() {
        List<String> countries = Arrays.asList("Канада", "США", "Россия", "Китай", "Польша");
        List<RARS> rarsList = Arrays.asList(RARS.TWELVE_PLUS, RARS.SIX_PLUS, RARS.ZERO_PLUS, RARS.EIGHTEEN_PLUS, RARS.SIXTEEN_PLUS);
        List<MPAA> mpaaList = Arrays.asList(MPAA.PARENTAL_GUIDANCE_SUGGESTED, MPAA.GENERAL_AUDIENCES, MPAA.NO_ONE_SEVENTEEN_AND_UNDER_ADMITTED, MPAA.PARENTS_STRONGLY_CAUTIONED);

        for (int i = 1; i <= COUNT_MOVIE; i++) {
            Movie movie = new Movie();
            movie.setName("фильм" + i);
            movie.setCountry(countries.get(random.nextInt(countries.size())));
            movie.setDateRelease(LocalDate.of(2000, 2, 7));
            movie.setRars(rarsList.get(random.nextInt(rarsList.size())));
            movie.setMpaa(mpaaList.get(random.nextInt(mpaaList.size())));
            movie.setDescription("description");
            movie.setPreviewIsExist(false);
            movieService.update(movie);
        }
    }

    //TODO сделать по аналогии с Movie
    public void addNews() {
        News news1 = new News();

        news1.setRubric(ABOUT_CINEMA);
        news1.setDate(LocalDateTime.of(LocalDate.of(2022, 1, 12), LocalTime.of(12, 21, 12)));
        news1.setTitle("title1");
        news1.setDescription("description1");
        newsService.update(news1);
    }

    public void addWatchlist(List<User> users) {
        for (User user: users) {
            Watchlist watchlist1 = new Watchlist();
            Watchlist watchlist2 = new Watchlist();
            Watchlist watchlist3 = new Watchlist();

            watchlist1.setUser(user);
            //TODO set Category и Privacy сделать по аналогии с фильмами
            watchlist1.setCategory(Category.WAITING_MOVIES);
            watchlist1.setPrivacy(PUBLIC);
            watchlist1.setDescription("description");
            watchlistService.update(watchlist1);

            watchlist2.setUser(user);
            watchlist2.setCategory(Category.FAVORITE_MOVIES);
            watchlist2.setPrivacy(PUBLIC);
            watchlist2.setDescription("description");
            watchlistService.update(watchlist2);

            watchlist3.setUser(user);
            watchlist3.setCategory(Category.WILL_WATCH);
            watchlist3.setPrivacy(PUBLIC);
            watchlist3.setDescription("description");
            watchlistService.update(watchlist3);
        }
    }
}
