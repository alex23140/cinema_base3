package com.kata.cinema.base.models.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = {"id", "name"})
@Entity
@Table(name = "genres")
public class Genre {
    @Id
    @GeneratedValue(generator = "genre_gen", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "genre_gen", sequenceName = "genre_id_seq", allocationSize = 1)
    private Long id;

    @Column(name = "name", nullable = false, unique = true)
    private String name;
}
