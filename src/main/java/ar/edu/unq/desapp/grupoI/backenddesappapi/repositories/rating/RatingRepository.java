package ar.edu.unq.desapp.grupoi.backenddesappapi.repositories.rating;

import ar.edu.unq.desapp.grupoi.backenddesappapi.exceptions.RatingHasBeenAddedException;
import ar.edu.unq.desapp.grupoi.backenddesappapi.model.rating.Rating;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Repository;

import java.util.List;
//@Configuration
//@Repository
public interface RatingRepository {

    List<Rating> getRatings();

    List<Rating> getRating(String tittle_tconst);

    void addRating(Rating rating) throws RatingHasBeenAddedException;

}
