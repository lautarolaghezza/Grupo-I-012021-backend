package repository.review;

import model.reviews.Review;

import java.util.List;

public interface ReviewRepository {

    List<Review> getReviews();

    List<Review> getReviews(String tittle_tconst);

    void addReview(Review review);

}
