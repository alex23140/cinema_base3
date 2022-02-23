package com.kata.cinema.base.models.entity;

import lombok.*;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"id"})
@Entity
@Table(name = "persons")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "originFirstName")
    private String originFirstName;

    @Column(name = "originLastName")
    private String originLastName;

    @Column(name = "avatarIsExist")
    private Boolean avatarIsExist;

    @Column(name = "growth")
    private Double growth;

    @Column(name = "birthday")
    @Type(type = "org.hibernate.type.LocalDateType")
    private LocalDate birthday;

    @Column(name = "place_of_birth")
    private String placeBirth;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "person_profession",
            joinColumns = @JoinColumn(name = "person_id"),
            inverseJoinColumns = @JoinColumn(name = "profession_id"))
    private Set<Profession> professions;

}
