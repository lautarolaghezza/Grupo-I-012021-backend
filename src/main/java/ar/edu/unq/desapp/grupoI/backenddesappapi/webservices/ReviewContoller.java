package ar.edu.unq.desapp.grupoi.backenddesappapi.webservices;



import ar.edu.unq.desapp.grupoi.backenddesappapi.services.reviewService.ReviewServiceImpl;
import ar.edu.unq.desapp.grupoi.backenddesappapi.services.userService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

@RestController
@EnableAutoConfiguration
public class ReviewContoller {

    @Autowired
    private ReviewServiceImpl reviewService;

    //@Autowired
    UserService userService;

    @GetMapping(value = "/hello")
    public String hello() {
        return "hola";
    }

}
