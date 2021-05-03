package service.ratingService;


import model.rating.Rating;

import java.util.List;

public interface RatingService {

    List<Rating> getAllRatings();

    List<Rating> getRatings(String tittle_tconst);

    void addRating(Rating user);
}
