package ar.edu.unq.desapp.grupoi.backenddesappapi.model.films;

import ar.edu.unq.desapp.grupoi.backenddesappapi.model.reviews.Review;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "Classifiable")
public abstract class Classifiable {

    @Id
    protected String tconst;

    @Column
    Double rating;


    @OneToOne()
    @JoinColumn(name = "crewtconst")
    Crew crew;

    @OneToOne()
    @JoinColumn(name = "principaltconst")
    Principals principals;


    public Classifiable(String tconst) {
        this.tconst = tconst;

    }

    public double getRating() {
        double totalRatingReviews = 1.5;
        double totalRatingCritics = 2.5;
        int total = 2;

        return (totalRatingCritics + totalRatingReviews) / total;
    }

    public void addRating(List<Review> reviews) {
        double totalRatingReviews = reviews.stream().mapToDouble(Review::getRating).sum();
        int total = reviews.size();
        this.rating = totalRatingReviews / total;
    }

}
