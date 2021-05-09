package ar.edu.unq.desapp.grupoi.backenddesappapi.services.reviewService;

//import lombok.Getter;
import ar.edu.unq.desapp.grupoi.backenddesappapi.exceptions.ReviewsNotFoundException;
import ar.edu.unq.desapp.grupoi.backenddesappapi.model.filter.*;
import ar.edu.unq.desapp.grupoi.backenddesappapi.model.reviews.Review;
import ar.edu.unq.desapp.grupoi.backenddesappapi.model.user.CommonUserAbs;
import ar.edu.unq.desapp.grupoi.backenddesappapi.model.user.UserAbs;
import ar.edu.unq.desapp.grupoi.backenddesappapi.repositories.review.ReviewRepository;
import ar.edu.unq.desapp.grupoi.backenddesappapi.services.userService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;

//import ar.edu.unq.desapp.grupoXXX.backenddesappapi.repositories.review.ReviewRepositoryImpl;

@Service
public class ReviewService  {

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private UserService userService;

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
    public List<Review> getReviewsWithFilter(LinkedHashMap<String, String> filters) throws FileNotFoundException {
        List<Filter> filterList = this.convertMapToListFilter(filters);
        List<UserAbs> userAbsList = userService.findAll();
        List<Review> result = reviewRepository.findAll();
        for ( Filter filter :  filterList) {
            result = filter.doFilter(result, userAbsList);
        }
        return result;
    }

    private List<Filter> convertMapToListFilter(LinkedHashMap<String, String> filters) throws FileNotFoundException {
    List<Filter> listFilter= new ArrayList<>();
    System.out.println(filters);
    for (String filter :  filters.keySet()){
        System.out.println(filter);
        switch (filter){
            case "language":
                listFilter.add(new LanguageFilter(filters.get("language")));
                break;
            case "location":
                listFilter.add(new LocationFilter(filters.get("location")));
                break;
            case "platform":
                listFilter.add(new PlatformFilter(filters.get("platform")));
                break;
            case "spoilerAlert":
                listFilter.add(new SpoilerAlertFilter(filters.get("spoilerAlert").equalsIgnoreCase("true")));
                break;
            case "typeUser":
                listFilter.add(new TypeUserFilter(filters.get("typeUser")));
                break;
            default: throw new FileNotFoundException();
        }
    }
    return  listFilter;
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
