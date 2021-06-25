package ar.edu.unq.desapp.grupoi.backenddesappapi.services.reviewService;

//import lombok.Getter;

import ar.edu.unq.desapp.grupoi.backenddesappapi.dto.ReviewOrderDTO;
import ar.edu.unq.desapp.grupoi.backenddesappapi.exceptions.NoSuchReview;
import ar.edu.unq.desapp.grupoi.backenddesappapi.exceptions.NoSuchReviewsWithTitle;
import ar.edu.unq.desapp.grupoi.backenddesappapi.exceptions.ReviewsNotFoundException;
import ar.edu.unq.desapp.grupoi.backenddesappapi.model.filter.*;
import ar.edu.unq.desapp.grupoi.backenddesappapi.model.reviews.Review;
import ar.edu.unq.desapp.grupoi.backenddesappapi.model.user.UserAbs;
import ar.edu.unq.desapp.grupoi.backenddesappapi.repositories.review.ReviewRepository;
import ar.edu.unq.desapp.grupoi.backenddesappapi.services.userService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;

//import ar.edu.unq.desapp.grupoXXX.backenddesappapi.repositories.review.ReviewRepositoryImpl;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private UserService userService;

    public List<Review> findAll() {
        return iterableToList(this.reviewRepository.findAll());
    }

    private List<Review> iterableToList(Iterable<Review> iterable) {
        List<Review> reviews = new ArrayList<>();
        for (Review review : iterable) {
            reviews.add(review);
        }
        return reviews;
    }

    public Review findById(Long id) {
        return this.reviewRepository.findById(id).orElseThrow(() -> new ReviewsNotFoundException(HttpStatus.BAD_REQUEST));
    }

    public List<Review> findReviewsForTitle(String tconst) {
        List<Review> reviews = this.reviewRepository.findReviewsForTitle(tconst);
        if(reviews.isEmpty()) throw new NoSuchReviewsWithTitle(HttpStatus.BAD_REQUEST);
        return reviews;
    }

    //@Override
    public List<Review> getReviews(String tittle_tconst) {
        List<Review> all = iterableToList(reviewRepository.findAll());
        List<Review> result = all.stream()
                .filter(r -> r.getTittle_tconst()
                        .equalsIgnoreCase(tittle_tconst))
                .collect(Collectors.toList());
        if (result.isEmpty()) {
            throw new ReviewsNotFoundException(HttpStatus.BAD_REQUEST);
        } else {
            return result;
        }
    }

    public List<Review> getReviewsWithFilter(LinkedHashMap<String, String> filters) {
        List<Filter> filterList = this.convertMapToListFilter(filters);
        List<UserAbs> userAbsList = userService.findAll();
        List<Review> result = iterableToList(reviewRepository.findAll());
        for (Filter filter : filterList) {
            result = filter.doFilter(result, userAbsList);
        }
        return result;
    }

    @Transactional
    public Review save(UserAbs user, Review review) {
        review.setUserAbs(user);
        return this.reviewRepository.save(review);
    }


    private List<Filter> convertMapToListFilter(LinkedHashMap<String, String> filters) {
        List<Filter> listFilter = new ArrayList<>();
        System.out.println(filters);
        for (String filter : filters.keySet()) {
            System.out.println(filter);
            switch (filter) {
                case "language":
                    listFilter.add(new LanguageFilter(filters.get("language")));
                    break;
                case "location":
                    listFilter.add(new LocationFilter(filters.get("location")));
                    break;
                case "platform":
                    listFilter.add(new PlatformFilter(filters.get("platform")));
                    break;
                case "spoiler_alert":
                    listFilter.add(new SpoilerAlertFilter(filters.get("spoiler_alert").equalsIgnoreCase("true")));
                    break;
                case "typeUser":
                    listFilter.add(new TypeUserFilter(filters.get("typeUser")));
                    break;
            }
        }
        return listFilter;
    }

    public List<Review> getReviewsWithOrder(ReviewOrderDTO reviewOrder) {
        List<Review> allReviews = findAll();
        if (reviewOrder.isDateAsc()) return allReviews.stream().sorted(Comparator.comparing(Review::getDate)).collect(Collectors.toList());
        if (reviewOrder.isDateDesc()) return allReviews.stream().sorted(Comparator.comparing(Review::getDate).reversed()).collect(Collectors.toList());
        if (reviewOrder.isRatingDesc()) return allReviews.stream().sorted(Comparator.comparing(Review::getRating)).collect(Collectors.toList());
        if (reviewOrder.isRatingAsc()) return allReviews.stream().sorted(Comparator.comparing(Review::getRating).reversed()).collect(Collectors.toList());
        return allReviews;
    }


  /*  public List<Review> orderByRatingAsc(List<Review> reviews) {
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
*/


}
