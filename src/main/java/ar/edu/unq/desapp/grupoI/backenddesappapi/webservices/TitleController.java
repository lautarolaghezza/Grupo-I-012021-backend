package ar.edu.unq.desapp.grupoi.backenddesappapi.webservices;

import ar.edu.unq.desapp.grupoi.backenddesappapi.model.films.Title;
import ar.edu.unq.desapp.grupoi.backenddesappapi.services.AuthServiceImpl;
import ar.edu.unq.desapp.grupoi.backenddesappapi.services.TitleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@EnableAutoConfiguration
public class TitleController {

    @Autowired
    private TitleService titleService;

    @Autowired
    AuthServiceImpl authService;

    @GetMapping(value = "titles")
    public ResponseEntity<List<Title>> findAll(@RequestHeader("api-key") String apiKey) {
        System.out.println("apiKey = " + apiKey);
        try {
            authService.validateUserToken(apiKey);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
        List<Title> titles = titleService.findAll();
        return new ResponseEntity<>(titles, HttpStatus.OK);
    }

    @GetMapping(value = "title/{id}")
    public Title findByID(@PathVariable String id) {
        return titleService.findById(id);
    }

    @GetMapping(value = "titles/findAny")
    public List<Title> getTitlesMatch(@RequestBody Title title) {
        return titleService.findReviewsMatch(title);
    }

}
