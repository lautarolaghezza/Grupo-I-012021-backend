package ar.edu.unq.desapp.grupoi.backenddesappapi.webservices;

import ar.edu.unq.desapp.grupoi.backenddesappapi.Utils.BaseController;
import ar.edu.unq.desapp.grupoi.backenddesappapi.dto.InverseSearchDTO;
import ar.edu.unq.desapp.grupoi.backenddesappapi.dto.SubscribeDTO;
import ar.edu.unq.desapp.grupoi.backenddesappapi.model.films.Title;
import ar.edu.unq.desapp.grupoi.backenddesappapi.services.TitleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.List;

@RestController
@EnableAutoConfiguration
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT})
public class TitleController extends BaseController {

    @Autowired
    private TitleService titleService;

    @GetMapping(value = "titles")
    public List<Title> findAll(@RequestHeader("api-key") String apiKey) {
        validateApiKey(apiKey);
        return titleService.findAll();
    }

    @GetMapping(value = "title/{id}")
    public Title findByID(@RequestHeader("api-key") String apiKey, @PathVariable String id) {
        validateApiKey(apiKey);
        return titleService.findById(id);
    }

    @PostMapping(value="title/subscribe")
    public void subscribeToReview(@RequestHeader("api-key") String apiKey, @RequestBody SubscribeDTO subscribeDTO){
        validateApiKey(apiKey);
        titleService.subscribe(subscribeDTO);
    }

    @PostMapping(value="title/unsubscribe")
    public void unsubscribeToReview(@RequestHeader("api-key") String apiKey, @RequestBody SubscribeDTO subscribeDTO){
        validateApiKey(apiKey);
        titleService.unsubscribe(subscribeDTO);
    }

    @GetMapping(value="title/subscribers/{id}")
    public List<String> getSubscribers(@RequestHeader("api-key") String apiKey, @PathVariable String id){
        validateApiKey(apiKey);
        return titleService.getSubscribers(id);
    }

    @GetMapping(value = "titles/findAny")
    public List<Title> getTitlesMatch(@RequestHeader("api-key") String apiKey, @RequestBody InverseSearchDTO inverseSearchDTO) {
        validateApiKey(apiKey);
        return titleService.findReviewsMatch(inverseSearchDTO);
    }

    @GetMapping(value = "titles/findAnycr")
    public List<Title> getTitlesMatchCriteria(@RequestHeader("api-key") String apiKey, @RequestBody LinkedHashMap<String, String> filters) {
        validateApiKey(apiKey);
        return titleService.searchReverseCriteria(filters);
    }

}
