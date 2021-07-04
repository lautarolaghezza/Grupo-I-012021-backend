package ar.edu.unq.desapp.grupoi.backenddesappapi.model.films;

import ar.edu.unq.desapp.grupoi.backenddesappapi.model.rating.Rating;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "Classifiable")
public abstract class Classifiable {

    @Id
    protected String tconst;

    @OneToOne()
    @JoinColumn(name = "ratingtconst")
    Rating rating;


    @OneToOne()
    @JoinColumn(name = "crewtconst")
    Crew crew;

    @OneToOne()
    @JoinColumn(name = "principaltconst")
    Principals principals;


    public Classifiable(String tconst) {
        this.tconst = tconst;
    }
}
