package com.kata.cinema.base.webapp.configs;

import com.kata.cinema.base.models.entity.*;
import com.kata.cinema.base.models.enums.*;
import com.kata.cinema.base.service.abstracts.entity.*;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;

@Component
@ConditionalOnExpression("'${spring.jpa.hibernate.ddl-auto}'=='create'")
public class TestDataInitializer {

    private final RoleService roleService;
    private final UserService userService;
    private final MovieService movieService;
    private final NewsService newsService;
    private final WatchlistService watchlistService;
    private final GenreService genreService;
    private final ProfessionService professionService;
    private final PersonService personService;
    private final MoviePersonInformationService moviePersonInformationService;

    private final Random random = new Random(System.currentTimeMillis());
    private static final int COUNT_USERS = 10;
    private static final int COUNT_ADMINS = 2;
    private static final int COUNT_MOVIE = 20;
    private static final int COUNT_NEWS = 20;
    private static final int COUNT_PERSON = 20;
    private static final int COUNT_GENRE = 10;
    private static final int COUNT_PROFESSION = 20;
    private static final int COUNT_M_P_I = 5;

    public TestDataInitializer(RoleService roleService, UserService userService, MovieService movieService, NewsService newsService, WatchlistService watchlistService, GenreService genreService, ProfessionService professionService, PersonService personService, MoviePersonInformationService moviePersonInformationService) {
        this.roleService = roleService;
        this.userService = userService;
        this.movieService = movieService;
        this.newsService = newsService;
        this.watchlistService = watchlistService;
        this.genreService = genreService;
        this.professionService = professionService;
        this.personService = personService;
        this.moviePersonInformationService = moviePersonInformationService;

    }

    @PostConstruct
    public void init() {
        addGenre();
        addProfession();
        addPerson();
        addRole();
        addMovie();
        addUser();
        addNews();
        addMoviePersonInformation();
    }

    public void addGenre() {
        for (int i = 0; i < COUNT_GENRE; i++) {
            Genre genre = new Genre();
            genre.setName("Genre" + i);
            genreService.create(genre);
        }
    }

    public void addProfession() {
        for (int i = 0; i < COUNT_PROFESSION; i++) {
            Profession profession = new Profession();
            profession.setName("Profession" + i);
            professionService.create(profession);
        }
    }

    public void addPerson() {
        for (int i = 0; i < COUNT_PERSON; i++) {
            Person person = new Person();
            person.setFirstName("firstName" + i);
            person.setLastName("lastName" + i);
            person.setGrowth(4.3);
            person.setBirthday(LocalDate.of(2022, 1, 12));
            person.setPlaceBirth("placeBirth" + i);
            personService.create(person);
        }
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
            user.setLastName("Фамилия" + i);
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
            admin.setLastName("Фамилия" + i);
            admin.setPassword("admin");
            admin.setBirthday(LocalDate.of(1995, 11, 12));
            admin.setEnabled(true);
            users.add(admin);
            userService.create(admin);
        }
        addWatchlist(users);
    }

    public void addNews() {
        List<Rubric> rubricList = Arrays.asList(Rubric.INTERVIEW, Rubric.ABOUT_CINEMA, Rubric.WHAT_IS_NEW);

        for (int i = 1; i <= COUNT_NEWS; i++) {
            News news1 = new News();

            news1.setRubric(rubricList.get(random.nextInt(rubricList.size())));
            news1.setDate(LocalDateTime.of(LocalDate.of(2022, 1, 12), LocalTime.of(12, 21, 12)));
            news1.setTitle("title " + i);
            news1.setDescription("description1");
            newsService.create(news1);
        }
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
            movie.setGenres(randomSetGenres());
            movieService.create(movie);
        }
    }

    public void addWatchlist(List<User> users) {

        List<Category> categoryList = Arrays.asList(Category.WAITING_MOVIES, Category.FAVORITE_MOVIES, Category.WILL_WATCH);
        List<Privacy> privacyList = Arrays.asList(Privacy.PUBLIC, Privacy.PRIVATE);

        for (User user : users) {
            Watchlist watchlist = new Watchlist();
            watchlist.setUser(user);
            watchlist.setCategory(categoryList.get(random.nextInt(categoryList.size())));
            watchlist.setPrivacy(privacyList.get(random.nextInt(privacyList.size())));
            watchlist.setDescription("description");
            /// добавляем список фильмов
            watchlist.setMovies(randomSetMovies());
            watchlistService.create(watchlist);
        }
    }

    public void addMoviePersonInformation() {

        for (int i = 1; i <= COUNT_M_P_I; i++) {
            MoviePersonInformation moviePersonInformation = new MoviePersonInformation();

            moviePersonInformation.setMovie(randomMovies());
            moviePersonInformation.setPerson(randomPerson());
            moviePersonInformation.setProfessions(randomSetProfession());
/// не работает сохранение
          //  moviePersonInformationService.create(moviePersonInformation);
        }
    }

    private Set<Movie> randomSetMovies() {
        Set<Movie> movieSet = new HashSet<>();

        List<Movie> movieList = movieService.getAll();

        for (int i = 0; i < random.nextInt(movieList.size()); i++) {
            movieSet.add(randomMovies());
        }

        return movieSet;
    }

    private Movie randomMovies() {

        List<Movie> movieList = movieService.getAll();
        return movieList.get(random.nextInt(movieList.size()));
    }

    private Set<Genre> randomSetGenres() {
        Set<Genre> genreSet = new HashSet<>();

        List<Genre> genreList = genreService.getAll();

        for (int i = 0; i < random.nextInt(genreList.size()); i++) {
            genreSet.add(genreList.get(random.nextInt(genreList.size())));
        }

        return genreSet;
    }

    private Person randomPerson() {

        List<Person> personList = personService.getAll();
        return personList.get(random.nextInt(personList.size()));
    }

    private Set<Profession> randomSetProfession() {
        Set<Profession> professionSet = new HashSet<>();

        List<Profession> professionList = professionService.getAll();

        for (int i = 0; i < random.nextInt(professionList.size()); i++) {
            professionSet.add(professionList.get(random.nextInt(professionList.size())));
        }

        return professionSet;
    }

}
