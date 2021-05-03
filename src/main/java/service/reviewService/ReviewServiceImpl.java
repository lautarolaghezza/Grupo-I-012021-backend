package service.reviewService;

import exceptions.ReviewsNotFoundException;
import lombok.Getter;
import model.filter.Filter;
import model.reviews.PublicReview;
import model.reviews.Review;
import model.user.CommonUser;
import org.springframework.stereotype.Service;
import repository.review.ReviewRepositoryImpl;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
@Getter
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepositoryImpl reviewRepository;

    public ReviewServiceImpl() {this.reviewRepository = new ReviewRepositoryImpl();}

    @Override
    public List<Review> getAllReviews() {
        return this.reviewRepository.getReviews();
    }

    @Override
    public List<Review> getReviews(String tittle_tconst) {
        List<Review> result = reviewRepository.getReviews(tittle_tconst);
        if(result.isEmpty()){
            throw new ReviewsNotFoundException();
        }else{
            return result;
        }
    }

    @Override
    public List<Review> getReviewsWithFilter(List<Filter> filters) {
        List<Review> result = reviewRepository.getReviews();
        for ( Filter filter :  filters) {
            result = filter.doFilter(reviewRepository.getReviews());
        }
        return result;
    }

    @Override
    public List<Review> orderByRatingAsc(List<Review> reviews) {
        reviews.sort(Comparator.comparing(Review::getRating));
        return reviews;
    }

    @Override
    public List<Review> orderByRatingDesc(List<Review> reviews) {
        reviews.sort(Comparator.comparing(Review::getRating));
        Collections.reverse(reviews);
        return reviews;
    }

    @Override
    public List<Review> orderByDateAsc(List<Review> reviews) {
        reviews.sort(Comparator.comparing(Review::getDate));
        return reviews;
    }

    @Override
    public List<Review> orderByDateDesc(List<Review> reviews) {
        reviews.sort(Comparator.comparing(Review::getDate));
        Collections.reverse(reviews);
        return reviews;
    }

    @Override
    public void addReview(CommonUser user, PublicReview review) {
        Review createdReview = user.createReview(review.getTittle_id(),
                review.getTittle_tconst(),
                review.getResume(),
                review.getExtendedText(),
                review.getRating(),
                review.getDate(),
                review.getLanguage(),
                review.isSpoiler_Alert());
        this.reviewRepository.addReview(createdReview);
    }
}
