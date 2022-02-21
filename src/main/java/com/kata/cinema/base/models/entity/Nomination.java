package com.kata.cinema.base.models.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "nomination")
public class Nomination {
    @Id
    @GeneratedValue(generator = "nomination_gen", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "nomination_gen", sequenceName = "nomination_id_seq", allocationSize = 1)
    private Long id;

    @Column(name = "name")
    private String name;
}
