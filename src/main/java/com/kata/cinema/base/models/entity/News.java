package com.kata.cinema.base.models.entity;

import com.kata.cinema.base.models.enums.Rubric;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "news")
public class News {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "rubric")
    private Rubric rubric;

    @Column(name = "date")
    @Type(type = "org.hibernate.type.LocalDateTimeType")
    private LocalDateTime date;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;
}
