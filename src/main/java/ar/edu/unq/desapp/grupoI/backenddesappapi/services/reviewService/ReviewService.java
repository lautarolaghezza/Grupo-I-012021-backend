package ar.edu.unq.desapp.grupoi.backenddesappapi.services.reviewService;

//import lombok.Getter;
import ar.edu.unq.desapp.grupoi.backenddesappapi.dto.ReviewDTO;
import ar.edu.unq.desapp.grupoi.backenddesappapi.model.user.CommonUserAbs;
import ar.edu.unq.desapp.grupoi.backenddesappapi.repositories.review.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unq.desapp.grupoi.backenddesappapi.exceptions.ReviewsNotFoundException;
import ar.edu.unq.desapp.grupoi.backenddesappapi.model.filter.Filter;
import ar.edu.unq.desapp.grupoi.backenddesappapi.model.reviews.PublicReview;
import ar.edu.unq.desapp.grupoi.backenddesappapi.model.reviews.Review;
//import ar.edu.unq.desapp.grupoXXX.backenddesappapi.repositories.review.ReviewRepositoryImpl;

import javax.transaction.Transactional;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReviewService  {

    @Autowired
    private ReviewRepository reviewRepository;

    public List<Review> findAll() {
        return this.reviewRepository.findAll();
    }

    public Review findById(String id){
        return this.reviewRepository.findById(id).orElseThrow(ReviewsNotFoundException::new);
    }

    public List<Review> findReviewsForTitle(String tconst) {
        return this.reviewRepository.findReviewsForTitle(tconst);
    }

    //@Override
    public List<Review> getReviews(String tittle_tconst) {
        List<Review> all = reviewRepository.findAll();
        List<Review> result = all.stream()
                .filter(r -> r.getTittle_tconst()
                        .equalsIgnoreCase(tittle_tconst))
                .collect(Collectors.toList());
        if(result.isEmpty()){
            throw new ReviewsNotFoundException();
        }else{
            return result;
        }
    }
    @Transactional
    public Review save(CommonUserAbs user, Review review) {
        review.setUserAbs(user);
        return this.reviewRepository.save(review);
    }

    public List<Review> getReviewsWithFilter(List<Filter> filters) {
        List<Review> result = reviewRepository.findAll();
        for ( Filter filter :  filters) {
            result = filter.doFilter(reviewRepository.findAll());
        }
        return result;
    }


    public List<Review> orderByRatingAsc(List<Review> reviews) {
        reviews.sort(Comparator.comparing(Review::getRating));
        return reviews;
    }


    public List<Review> orderByRatingDesc(List<Review> reviews) {
        reviews.sort(Comparator.comparing(Review::getRating));
        Collections.reverse(reviews);
        return reviews;
    }


    public List<Review> orderByDateAsc(List<Review> reviews) {
        reviews.sort(Comparator.comparing(Review::getDate));
        return reviews;
    }


    public List<Review> orderByDateDesc(List<Review> reviews) {
        reviews.sort(Comparator.comparing(Review::getDate));
        Collections.reverse(reviews);
        return reviews;
    }



}
