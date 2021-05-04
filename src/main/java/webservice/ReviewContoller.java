package webservice;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import service.reviewService.ReviewService;
import service.userService.UserService;

@Controller
public class ReviewContoller {

    @Autowired
    ReviewService reviewService;

    @Autowired
    UserService userService;

    //@PostMapping(value= "/newreview")
    //public String newReview(@RequestBody ReviewDTO reviewDTO){
    //    User user = userService.getUser(reviewDTO.userId);
    //    PublicReview publicReview = new PublicReview(reviewDTO.tittle_id, reviewDTO.tittle_tconst,
    //            reviewDTO.resume, reviewDTO.extendedText, reviewDTO.rating, reviewDTO.date, reviewDTO.language,
    //            user, reviewDTO.spoiler_Alert);
    //    reviewService.addReview((CommonUser) user, publicReview);
    //    return "hola";
    //}

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public ResponseEntity<String> getResult() {
        return new ResponseEntity<>("Hello World", HttpStatus.OK);
    }

}
