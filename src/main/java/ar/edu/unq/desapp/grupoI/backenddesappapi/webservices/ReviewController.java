package ar.edu.unq.desapp.grupoi.backenddesappapi.webservices;


import ar.edu.unq.desapp.grupoi.backenddesappapi.dto.ReviewDTO;
import ar.edu.unq.desapp.grupoi.backenddesappapi.model.reviews.PremiumReview;
import ar.edu.unq.desapp.grupoi.backenddesappapi.model.reviews.PublicReview;
import ar.edu.unq.desapp.grupoi.backenddesappapi.model.reviews.Review;
import ar.edu.unq.desapp.grupoi.backenddesappapi.model.user.CommonUserAbs;
import ar.edu.unq.desapp.grupoi.backenddesappapi.services.reviewService.ReviewService;
import ar.edu.unq.desapp.grupoi.backenddesappapi.services.userService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@EnableAutoConfiguration
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    //@Autowired
    UserService userService;


    @GetMapping(value = "reviews")
    public List<Review> getReviews() {
        return reviewService.findAll();
    }

    @GetMapping(value = "review/{id}")
    public Review getReview(@PathVariable String id) {
        return reviewService.findById(id);
    }

    @GetMapping(value = "review/title/{tconst}")
    public List<Review> getReviewsForTitle(@PathVariable String tconst) {
        return reviewService.findReviewsForTitle(tconst);
    }

    @PostMapping(value = "/publicReview")
    public Review newPublicReview(@RequestBody PublicReview review) {
        CommonUserAbs user = new CommonUserAbs();
        user.setUserId(review.getUserId());
        return reviewService.save(user, review);
    }

    @PostMapping(value = "/premiumReview")
    public Review newPremiumReview(@RequestBody PremiumReview review) {
        CommonUserAbs user = new CommonUserAbs();
        user.setUserId(review.getUserId());
        return reviewService.save(user, review);
    }

    @GetMapping(value = "/hello")
    public String hello() {
        return "hola";
    }

}
