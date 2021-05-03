package model.films;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import model.reviews.PremiumReview;
import model.reviews.PublicReview;
import model.reviews.Review;

import javax.persistence.Id;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public abstract class Classifiable {

    @Id
    private String tconst;
    private List<PremiumReview> critics;
    private List<PublicReview> reviews;


    public Classifiable(String tconst, List<PremiumReview> critics, List<PublicReview> reviews) {
        this.tconst = tconst;
        this.critics = critics;
        this.reviews = reviews;
    }

    public double getRating() {
        double totalRatingReviews = reviews.stream().mapToDouble(Review::getRating).sum();
        double totalRatingCritics = critics.stream().mapToDouble(Review::getRating).sum();
        int total = reviews.size() + critics.size();

        return (totalRatingCritics + totalRatingReviews) / total;
    }
}
