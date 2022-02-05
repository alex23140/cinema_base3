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
public class Professions {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    Long id;

    @Column(name = "name")
    String name;
}
