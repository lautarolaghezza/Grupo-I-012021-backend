package ar.edu.unq.desapp.grupoi.backenddesappapi.model.films;

import ar.edu.unq.desapp.grupoi.backenddesappapi.model.reviews.PremiumReview;
import ar.edu.unq.desapp.grupoi.backenddesappapi.model.reviews.PublicReview;
import ar.edu.unq.desapp.grupoi.backenddesappapi.model.reviews.Review;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.List;

@Entity
@Table(name="Classifiable")
public abstract class Classifiable {

    @Id
    private String tconst;

    @Transient
    private List<PremiumReview> critics;
    @Transient
    private List<PublicReview> reviews;

    public Classifiable() {
    }

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

    public String getTconst() {
        return tconst;
    }

    public List<PremiumReview> getCritics() {
        return critics;
    }

    public List<PublicReview> getReviews() {
        return reviews;
    }

    public void setTconst(String tconst) {
        this.tconst = tconst;
    }

    public void setCritics(List<PremiumReview> critics) {
        this.critics = critics;
    }

    public void setReviews(List<PublicReview> reviews) {
        this.reviews = reviews;
    }
}
