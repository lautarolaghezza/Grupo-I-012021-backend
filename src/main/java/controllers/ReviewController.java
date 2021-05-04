package controllers;

import dto.ReviewDTO;
import model.reviews.PublicReview;
import model.reviews.Review;
import model.user.CommonUser;
import model.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;
import service.reviewService.ReviewService;
import service.userService.UserService;

import java.util.List;

@RestController
@EnableAutoConfiguration
@RequestMapping(value = "/review")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
public class ReviewController {

    @Autowired
    ReviewService reviewService;

    @Autowired
    UserService userService;


    @RequestMapping(value="reviews")
    public List<Review> getReviews(){
        return reviewService.getAllReviews();
    }

    @RequestMapping(value= "/newreview")
    public String newReview(@RequestBody ReviewDTO reviewDTO){
        User user = userService.getUser(reviewDTO.userId);

        PublicReview publicReview = new PublicReview(reviewDTO.tittle_tconst,
                reviewDTO.resume, reviewDTO.extendedText, reviewDTO.rating, reviewDTO.date, reviewDTO.language,
                user, reviewDTO.spoiler_Alert);
        reviewService.addReview((CommonUser) user, publicReview);
        return "hola";
    }

    @RequestMapping("/hello")
    public String hello(){
        return "hola";
    }

}
