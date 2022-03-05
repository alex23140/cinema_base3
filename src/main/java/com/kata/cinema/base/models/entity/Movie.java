package com.kata.cinema.base.models.entity;

import com.kata.cinema.base.models.enums.MPAA;
import com.kata.cinema.base.models.enums.RARS;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = {"id", "name"})
@Entity
@Table(name = "movies")
public class Movie {
    @Id
    @GeneratedValue(generator = "movies_gen", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "movies_gen", sequenceName = "movies_id_seq", allocationSize = 1)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "country")
    private String country;

    @Column(name = "original_name")
    private String originalName;

    @Column(name = "date_release")
    private LocalDate dateRelease;

    @Enumerated(EnumType.STRING)
    @Column(name = "rars")
    private RARS rars;

    @Enumerated(EnumType.STRING)
    @Column(name = "mpaa")
    private MPAA mpaa;

    @Column(name = "description")
    private String description;

    @Column(name = "preview_is_exist")
    private Boolean previewIsExist = false;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "movies_genres",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id"))
    private Set<Genre> genres;
}
