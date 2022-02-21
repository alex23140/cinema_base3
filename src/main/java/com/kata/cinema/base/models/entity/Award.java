package com.kata.cinema.base.models.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "award")
public class Award {
    @Id
    @GeneratedValue(generator = "award_gen", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "award_gen", sequenceName = "award_id_seq", allocationSize = 1)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "descriptor")
    private String descriptor;
}
