package com.kata.cinema.base.models.entity;


import com.kata.cinema.base.models.Category;
import com.kata.cinema.base.models.Privacy;
import lombok.*;

import javax.persistence.*;

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
}
