package ar.edu.unq.desapp.grupoi.backenddesappapi.services.ratingService;


import ar.edu.unq.desapp.grupoi.backenddesappapi.model.rating.Rating;

import java.util.List;

public interface RatingService {

    List<Rating> getAllRatings();

    List<Rating> getRatings(String tittle_tconst);

    void addRating(Rating user);
}
