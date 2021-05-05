package ar.edu.unq.desapp.grupoi.backenddesappapi.services.ratingService;

import ar.edu.unq.desapp.grupoi.backenddesappapi.model.rating.Rating;
import ar.edu.unq.desapp.grupoi.backenddesappapi.repositories.rating.RatingRepository;
import ar.edu.unq.desapp.grupoi.backenddesappapi.repositories.rating.RatingRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//@Service
public class RatingServiceImpl implements RatingService {

    //@Autowired
    private RatingRepository ratingRepository;

    public RatingRepository getRatingRepository() {
        return ratingRepository;
    }

    public RatingServiceImpl() {
        this.ratingRepository = new RatingRepositoryImpl();
    }

    @Override
    public List<Rating> getAllRatings() {
        return ratingRepository.getRatings();
    }

    @Override
    public List<Rating> getRatings(String tittle_tconst) {
        return ratingRepository.getRating(tittle_tconst);
    }

    @Override
    public void addRating(Rating rating) {
        ratingRepository.addRating(rating);
    }
}
