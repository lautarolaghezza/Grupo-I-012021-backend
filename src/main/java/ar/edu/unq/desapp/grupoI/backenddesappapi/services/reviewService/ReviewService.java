package ar.edu.unq.desapp.grupoi.backenddesappapi.services.reviewService;

import ar.edu.unq.desapp.grupoi.backenddesappapi.model.filter.Filter;
import ar.edu.unq.desapp.grupoi.backenddesappapi.model.reviews.PublicReview;
import ar.edu.unq.desapp.grupoi.backenddesappapi.model.reviews.Review;
import ar.edu.unq.desapp.grupoi.backenddesappapi.model.user.CommonUserAbs;

import java.util.List;

public interface ReviewService {


    List<Review> findAll();
    List<Review> findAllBy(String tittle_tconst);
    List<Review> getReviewsWithFilter(List<Filter> filters);
    List<Review> orderByRatingAsc(List<Review> reviews);
    List<Review> orderByRatingDesc(List<Review> reviews);
    List<Review> orderByDateAsc(List<Review> reviews);
    List<Review> orderByDateDesc(List<Review> reviews);
    void save(CommonUserAbs user, PublicReview review);

}
