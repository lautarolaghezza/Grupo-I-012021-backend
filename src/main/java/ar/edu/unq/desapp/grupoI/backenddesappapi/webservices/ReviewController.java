package ar.edu.unq.desapp.grupoi.backenddesappapi.webservices;


import ar.edu.unq.desapp.grupoi.backenddesappapi.dto.ReviewOrderDTO;
import ar.edu.unq.desapp.grupoi.backenddesappapi.model.reviews.PremiumReview;
import ar.edu.unq.desapp.grupoi.backenddesappapi.model.reviews.PublicReview;
import ar.edu.unq.desapp.grupoi.backenddesappapi.model.reviews.Review;
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
        validateApiKey(apiKey);
        return reviewService.getReviewsWithFilter(filters);
    }
    @GetMapping(value = "review/filterscr")
    public List<Review> findReviewsWithFilterCriteria(@RequestHeader("api-key") String apiKey, @RequestBody LinkedHashMap<String, String> filters) throws FileNotFoundException {
        validateApiKey(apiKey);
        return reviewService.findReviewsWithFilterCriteria(filters);
    }

    @GetMapping(value="review/orderBy")
    public List<Review> getReviewsByRating(@RequestHeader("api-key") String apiKey, @RequestBody ReviewOrderDTO reviewOrder) throws FileNotFoundException {
       validateApiKey(apiKey);
       return reviewService.getReviewsWithOrder(reviewOrder);
    }


        @PostMapping(value = "/publicReview")
    public Review newPublicReview(@RequestHeader("api-key") String apiKey, @RequestBody PublicReview review) {
        validateApiKey(apiKey);
        return reviewService.save(review);
    }

    @PostMapping(value = "/premiumReview")
    public Review newPremiumReview(@RequestHeader("api-key") String apiKey, @RequestBody PremiumReview review) {
        validateApiKey(apiKey);

        return reviewService.save(review);
    }

}
