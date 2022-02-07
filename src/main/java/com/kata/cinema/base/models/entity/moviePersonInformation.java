package com.kata.cinema.base.models.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;



@Getter
@Setter
@NoArgsConstructor
@Entity
@Embeddable
public class moviePersonInformation {

    @EmbeddedId
    private Id id;

    @Getter
    @Setter
    @NoArgsConstructor
    @Embeddable
    private class Id implements Serializable {
        @Column(name = "person_id")
        private Long personId;
        @Column(name = "movie_id")
        private Long movieId;

        public Id(Long personId, Long movieId) {
            this.personId = personId;
            this.movieId = movieId;
        }
    }
}
