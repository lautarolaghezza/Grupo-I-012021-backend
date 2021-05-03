package repository.rating;

import exceptions.RatingHasBeenAddedException;
import exceptions.ReviewHasBeenAddedException;
import model.films.Classifiable;
import model.rating.Rating;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class RatingRepositoryImpl implements  RatingRepository{

    List<Rating> ratings;

    public RatingRepositoryImpl() {
        this.ratings = new ArrayList<>();
    }

    @Override
    public List<Rating> getRatings() {
        return ratings;
    }

    @Override
    public List<Rating> getRating(String tittle_tconst) {
        return ratings.stream()
                .filter( r -> r.getTconst().equalsIgnoreCase(tittle_tconst))
                .collect(Collectors.toList());
    }

    @Override
    public void addRating(Rating rating) {
        boolean isAdded = this.ratings.stream().anyMatch(r -> r.getTconst().equalsIgnoreCase(rating.getTconst()));
        if (isAdded) throw new RatingHasBeenAddedException();
        this.ratings.add(rating);
    }
}
