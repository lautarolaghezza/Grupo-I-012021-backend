package service.reviewService;

import model.Filter;
import model.Platform;
import model.reviews.PublicReview;
import model.reviews.Review;
import model.user.CommonUser;
import model.user.User;

import java.time.LocalDate;
import java.util.List;

public interface ReviewService {

    List<Review> getReviews(int tittle_id);
    List<Review> getReviewsWithFilter(List<Filter> filters);
    List<Review> orderByRatingAsc(List<Review> reviews);
    List<Review> orderByRatingDesc(List<Review> reviews);
    List<Review> orderByDateAsc(List<Review> reviews);
    List<Review> orderByDateDesc(List<Review> reviews);
    void addReview(CommonUser user, PublicReview review);
}
