package controllers;

import dto.ReviewDTO;
import model.reviews.PublicReview;
import model.user.CommonUser;
import model.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.reviewService.ReviewService;
import service.userService.UserService;

import java.security.SecureRandom;

@RestController
@EnableAutoConfiguration
public class ReviewContoller {

    @Autowired
    ReviewService reviewService;

    @Autowired
    UserService userService;

    @PostMapping(value= "/newreview")
    public String newReview(@RequestBody ReviewDTO reviewDTO){
        User user = userService.getUser(reviewDTO.userId);

        PublicReview publicReview = new PublicReview(reviewDTO.tittle_id, reviewDTO.tittle_tconst,
                reviewDTO.resume, reviewDTO.extendedText, reviewDTO.rating, reviewDTO.date, reviewDTO.language,
                user, reviewDTO.spoiler_Alert);
        reviewService.addReview((CommonUser) user, publicReview);
        return "hola";
    }

    @GetMapping("/hello")
    public String hello(){
        return "hola";
    }

}
