package com.kata.cinema.base.models.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "awards_ceremony")
public class AwardsCeremony {
    @Id
    @GeneratedValue(generator = "awards_ceremony_gen", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "awards_ceremony_gen", sequenceName = "awards_ceremony_id_seq", allocationSize = 1)
    private Long id;

    @Column(name = "date_event")
    private LocalDate dateEvent;

    @Column(name = "place_event")
    private String placeEvent;

    @Column(name = "htmlBody")
    String htmlBody;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "award_id")
    private Award award;
}
