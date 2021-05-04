package service.reviewService;

import model.filter.Filter;
import model.reviews.PublicReview;
import model.reviews.Review;
import model.user.CommonUser;

import javax.transaction.Transactional;
import java.util.List;

public interface ReviewService {


    @Transactional
    List<Review> getAllReviews();
    @Transactional
    List<Review> getReviews(String tittle_tconst);
    @Transactional
    List<Review> getReviewsWithFilter(List<Filter> filters);
    @Transactional
    List<Review> orderByRatingAsc(List<Review> reviews);
    @Transactional
    List<Review> orderByRatingDesc(List<Review> reviews);
    @Transactional
    List<Review> orderByDateAsc(List<Review> reviews);
    @Transactional
    List<Review> orderByDateDesc(List<Review> reviews);
    @Transactional
    void addReview(CommonUser user, PublicReview review);

}
