package com.kata.cinema.base.models.entity;


import com.kata.cinema.base.models.enums.Category;
import com.kata.cinema.base.models.enums.Privacy;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"id", "name"})
@Entity
@Table(name = "watchlist")
public class Watchlist {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    Long id;

    @Column(name = "category")
    Category category ;

    @Column(name = "privacy")
    Privacy privacy ;

    @Column(name = "name")
    String name;

    @Column(name = "description")
    String description;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    User user;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "watchlist_movie",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "watchlist_id"))
    private Set<Movie> movies;
}
