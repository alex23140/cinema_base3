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
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(generator = "roles_gen", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "roles_gen", sequenceName = "roles_id_seq", allocationSize = 1)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;
}
