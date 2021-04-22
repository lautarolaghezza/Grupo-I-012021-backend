package model.films;

import lombok.Getter;
import lombok.Setter;
import model.reviews.PremiumReview;
import model.reviews.PublicReview;
import model.reviews.Review;

import java.util.List;

@Getter
@Setter
public class Title {
    private String tconst;
    private String titleType;
    private String primaryTitle;
    private String originalTitle;
    private Boolean isAdult;
    private Integer startYear;
    private Integer endYear;
    private Integer runtimeMinutes;
    private List<String> genres;
    private List<PremiumReview> critics;
    private List<PublicReview> reviews;


    public Title(String tconst, String titleType, String primaryTitle,
                 String originalTitle, Boolean isAdult,
                 Integer startYear, Integer endYear, Integer runtimeMinutes,
                 List<String> genres, List<PremiumReview> critics,
                 List<PublicReview> reviews) {
        this.tconst = tconst;
        this.titleType = titleType;
        this.primaryTitle = primaryTitle;
        this.originalTitle = originalTitle;
        this.isAdult = isAdult;
        this.startYear = startYear;
        this.endYear = endYear;
        this.runtimeMinutes = runtimeMinutes;
        this.genres = genres;
        this.critics = critics;
        this.reviews = reviews;
    }

    public Title() {
    }

    public double getRating() {
        double totalRatingReviews = reviews.stream().mapToDouble(Review::getRating).sum();
        double totalRatingCritics = critics.stream().mapToDouble(Review::getRating).sum();
        int total = reviews.size() + critics.size();

        return (totalRatingCritics + totalRatingReviews) / total;
    }
}
