package ar.edu.unq.desapp.grupoi.backenddesappapi.webservices;

import ar.edu.unq.desapp.grupoi.backenddesappapi.model.films.Title;
import ar.edu.unq.desapp.grupoi.backenddesappapi.model.reviews.Review;
import ar.edu.unq.desapp.grupoi.backenddesappapi.services.TitleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@EnableAutoConfiguration
public class TitleController {

    @Autowired
    private TitleService titleService;

    @GetMapping(value = "titles")
    public List<Title> findAll() {
        return titleService.findAll();
    }

    @GetMapping(value="title/{id}")
    public Title findByID(@PathVariable String id){
        return titleService.findById(id);
    }
    @GetMapping(value = "titles/findAny/{matcher}")
    public List<Title> getTitlesMatch(@PathVariable String matcher){
        return titleService.findReviewsMatch(matcher);
    }
}
