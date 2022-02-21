package com.kata.cinema.base.models.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "awards_ceremony_result")
public class AwardsCeremonyResult {
    @Id
    @GeneratedValue(generator = "awards_ceremony_result_gen", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "awards_ceremony_result_gen", sequenceName = "awards_ceremony_result_id_seq", allocationSize = 1)
    private Long id;

    @Column(name = "nominationStatus")
    private String nominationStatus;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "person_id")
    private Person person;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "movie_id")
    private Movie movie;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "nomination_id")
    private Nomination nomination;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "awards_ceremony_id")
    private AwardsCeremony awardsCeremony;
}
