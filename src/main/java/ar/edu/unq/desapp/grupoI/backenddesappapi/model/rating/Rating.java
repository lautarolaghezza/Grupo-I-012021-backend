package ar.edu.unq.desapp.grupoi.backenddesappapi.model.rating;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "rating")
public class Rating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private String tittle_tconst;
    @Column
    private float averageRating;
    @Column
    private int numVotes;

    public Rating(String tconst, float averageRating, int numVotes) {
        this.tittle_tconst = tconst;
        this.averageRating = averageRating;
        this.numVotes = numVotes;
    }
}
