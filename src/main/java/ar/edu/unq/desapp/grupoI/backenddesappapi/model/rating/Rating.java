package ar.edu.unq.desapp.grupoi.backenddesappapi.model.rating;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Getter
@Setter
@Entity
@Table(name = "rating")
public class Rating {
    @Id
    private String tconst;
    @Column
    private float averageRating;
    @Column
    private int numVotes;

    public Rating(String tconst, float averageRating, int numVotes) {
        this.tconst = tconst;
        this.averageRating = averageRating;
        this.numVotes = numVotes;
    }

    public Rating() {

    }

    public String getTconst() {
        return tconst;
    }

    public float getAverageRating() {
        return averageRating;
    }

    public int getNumVotes() {
        return numVotes;
    }
}
