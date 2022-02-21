package com.kata.cinema.base.models.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = {"id", "email"})
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(generator = "users_gen", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "users_gen", sequenceName = "users_id_seq", allocationSize = 1)
    private Long id;

    @Size(max = 50, message = "email должен быть короче 50 символов")
    @Column(name = "email", length = 50, nullable = false, unique = true)
    private String email;

    @Column(name = "nickname", nullable = false, unique = true)
    private String nickname;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    //TODO добавить валидатор на отсутствие пробелов (через @Pattern)
    @Size(min = 4, max = 60, message = "Пароль должен быть больше 4 символов и меньше 30")
    @Column(name = "password", length = 60, nullable = false)
    private String password;

    @Column(name = "birthday")
    @Type(type = "org.hibernate.type.LocalDateType")
    private LocalDate birthday;

    @Column(name = "enabled", nullable = false, columnDefinition = "SMALLINT")
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private Boolean enabled = true;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id")
    private Role role;
}