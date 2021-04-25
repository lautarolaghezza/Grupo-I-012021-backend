package service.reviewService;

import exceptions.ReviewsNotFoundException;
import lombok.Getter;
import model.filter.Filter;
import model.reviews.PublicReview;
import model.reviews.Review;
import model.user.CommonUser;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public class ReviewServiceImpl implements ReviewService {

    private final List<Review> serviceReviews;

    public ReviewServiceImpl(List<Review> serviceReviews) {
        this.serviceReviews = serviceReviews;
    }

    @Override
    public List<Review> getReviews(int tittle_id) {
        List<Review> result = serviceReviews
                            .stream()
                            .filter(r -> r.getTittle_id() == tittle_id).collect(Collectors.toList());
        if(result.size() > 0){
            return result;
        }else{
            throw new ReviewsNotFoundException();
        }
    }

    @Override
    public List<Review> getReviewsWithFilter(List<Filter> filters) {
        List<Review> result = serviceReviews;
        for ( Filter filter :  filters) {
            result = filter.doFilter(serviceReviews);
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
                review.getResume(),
                review.getExtendedText(),
                review.getRating(),
                review.getDate(),
                review.getLanguage(),
                review.isSpoiler_Alert());
        this.serviceReviews.add(createdReview);
    }
}
