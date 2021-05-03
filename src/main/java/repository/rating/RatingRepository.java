package repository.rating;

import exceptions.RatingHasBeenAddedException;
import model.films.Classifiable;
import model.rating.Rating;

import java.util.List;

public interface RatingRepository {

    List<Rating> getRatings();

    List<Rating> getRating(String tittle_tconst);

    void addRating(Rating rating) throws RatingHasBeenAddedException;

}
