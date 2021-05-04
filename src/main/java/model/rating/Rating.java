package model.rating;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Entity
@NoArgsConstructor
public class Rating {
    @Id
    private String tconst;
    private float averageRating;
    private int numVotes;

    public Rating(String tconst, float averageRating, int numVotes) {
        this.tconst = tconst;
        this.averageRating = averageRating;
        this.numVotes = numVotes;
    }

}
