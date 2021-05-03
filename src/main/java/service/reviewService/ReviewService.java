package service.reviewService;

import model.filter.Filter;
import model.reviews.PublicReview;
import model.reviews.Review;
import model.user.CommonUser;

import java.util.List;

public interface ReviewService {


    List<Review> getAllReviews();
    List<Review> getReviews(String tittle_tconst);
    List<Review> getReviewsWithFilter(List<Filter> filters);
    List<Review> orderByRatingAsc(List<Review> reviews);
    List<Review> orderByRatingDesc(List<Review> reviews);
    List<Review> orderByDateAsc(List<Review> reviews);
    List<Review> orderByDateDesc(List<Review> reviews);
    void addReview(CommonUser user, PublicReview review);

}
