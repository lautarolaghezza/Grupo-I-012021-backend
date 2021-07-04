package ar.edu.unq.desapp.grupoi.backenddesappapi.services.ratingService;

import ar.edu.unq.desapp.grupoi.backenddesappapi.model.rating.Rating;
import ar.edu.unq.desapp.grupoi.backenddesappapi.repositories.rating.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingService {

    @Autowired
    private RatingRepository ratingRepository;

    public RatingRepository getRatingRepository() {
        return ratingRepository;
    }

    public RatingService() {

    }

    public List<Rating> getAllRatings() {
        return ratingRepository.findAll();
    }

    public Rating getRatingById(String tittle_tconst) {
        return ratingRepository.findAllById(tittle_tconst);
    }

    public void addRating(Rating rating) {
        ratingRepository.save(rating);
    }
}
