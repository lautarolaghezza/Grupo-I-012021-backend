package ar.edu.unq.desapp.grupoi.backenddesappapi.webservices;



import ar.edu.unq.desapp.grupoi.backenddesappapi.model.reviews.Review;
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


    @GetMapping(value="reviews")
    public List<Review> getReviews(){
        return reviewService.findAll();
    }

    /*
    @PostMapping(value= "/newreview")
    public String newReview(@RequestBody ReviewDTO reviewDTO){
        UserAbs user = userService.getUser(reviewDTO.userId);

        PublicReview publicReview = new PublicReview(reviewDTO.tittle_tconst,
                reviewDTO.resume, reviewDTO.extendedText, reviewDTO.rating, reviewDTO.date, reviewDTO.language,
                user, reviewDTO.spoiler_Alert);
        reviewService.addReview((CommonUser) user, publicReview);
        return "hola";
    }
    */

    @GetMapping(value = "/hello")
    public String hello() {
        return "hola";
    }

}
