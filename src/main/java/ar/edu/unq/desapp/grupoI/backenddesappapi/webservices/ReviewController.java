package ar.edu.unq.desapp.grupoi.backenddesappapi.webservices;


import ar.edu.unq.desapp.grupoi.backenddesappapi.model.reviews.PremiumReview;
import ar.edu.unq.desapp.grupoi.backenddesappapi.model.reviews.PublicReview;
import ar.edu.unq.desapp.grupoi.backenddesappapi.model.reviews.Review;
import ar.edu.unq.desapp.grupoi.backenddesappapi.model.user.UserAbs;
import ar.edu.unq.desapp.grupoi.backenddesappapi.services.reviewService.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
import java.util.LinkedHashMap;
import java.util.List;

@RestController
@EnableAutoConfiguration
public class ReviewController extends BaseController {

    @Autowired
    private ReviewService reviewService;

    @GetMapping(value = "reviews")
    public List<Review> getReviews(@RequestHeader("api-key") String apiKey) {
        validateApiKey(apiKey);
        return reviewService.findAll();
    }

    @GetMapping(value = "review/{id}")
    public Review getReview(@RequestHeader("api-key") String apiKey, @PathVariable Long id) {
        validateApiKey(apiKey);
        return reviewService.findById(id);
    }


    @GetMapping(value = "review/title/{tconst}")
    public List<Review> getReviewsForTitle(@RequestHeader("api-key") String apiKey, @PathVariable String tconst) {
        validateApiKey(apiKey);
        return reviewService.findReviewsForTitle(tconst);
    }
    @GetMapping(value = "review/filters")
    public List<Review> getReviewsWithFilters(@RequestHeader("api-key") String apiKey, @RequestBody LinkedHashMap<String, String> filters) throws FileNotFoundException {
        //System.out.println(filters.getClass());
        validateApiKey(apiKey);
        return reviewService.getReviewsWithFilter(filters);
    }

    @PostMapping(value = "/publicReview")
    public Review newPublicReview(@RequestHeader("api-key") String apiKey, @RequestBody PublicReview review) {
        validateApiKey(apiKey);
        UserAbs user = new UserAbs();
        user.setId(review.getUserId());
        return reviewService.save(user, review);
    }

    @PostMapping(value = "/premiumReview")
    public Review newPremiumReview(@RequestHeader("api-key") String apiKey, @RequestBody PremiumReview review) {
        validateApiKey(apiKey);
        UserAbs user = new UserAbs();
        user.setId(review.getUserId());
        return reviewService.save(user, review);
    }

    @GetMapping(value = "/hello")
    public String hello() {
        return "hola";
    }

}
