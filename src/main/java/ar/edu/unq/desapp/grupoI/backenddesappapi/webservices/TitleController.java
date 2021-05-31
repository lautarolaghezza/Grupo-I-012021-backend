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
public class TitleController extends BaseController {

    @Autowired
    private TitleService titleService;

    @GetMapping(value = "titles")
    public ResponseEntity<List<Title>> findAll(@RequestHeader("api-key") String apiKey) {
        validateApiKey(apiKey);
        List<Title> titles = titleService.findAll();
        return new ResponseEntity<>(titles, HttpStatus.OK);
    }

    @GetMapping(value = "title/{id}")
    public Title findByID(@RequestHeader("api-key") String apiKey, @PathVariable String id) {
        validateApiKey(apiKey);
        return titleService.findById(id);
    }

    @GetMapping(value = "titles/findAny")
    public List<Title> getTitlesMatch(@RequestHeader("api-key") String apiKey, @RequestBody Title title) {
        validateApiKey(apiKey);
        return titleService.findReviewsMatch(title);
    }

}
