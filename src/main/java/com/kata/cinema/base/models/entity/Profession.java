package com.kata.cinema.base.models.entity;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collection;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = {"id"})
@Entity
@Table(name = "professions")
public class Profession {
    @Id
    @GeneratedValue(generator = "professions_gen", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "professions_gen", sequenceName = "professions_id_seq", allocationSize = 1)
    private Long id;

    @Column(name = "name")
    private String name;
}
