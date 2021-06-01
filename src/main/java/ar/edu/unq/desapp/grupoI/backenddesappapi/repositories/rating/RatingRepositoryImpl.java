package ar.edu.unq.desapp.grupoi.backenddesappapi.repositories.rating;

import ar.edu.unq.desapp.grupoi.backenddesappapi.exceptions.RatingHasBeenAddedException;
import ar.edu.unq.desapp.grupoi.backenddesappapi.model.rating.Rating;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


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
                .filter( r -> r.getTittle_tconst().equalsIgnoreCase(tittle_tconst))
                .collect(Collectors.toList());
    }

    @Override
    public void addRating(Rating rating) {
        boolean isAdded = this.ratings
                .stream()
                .anyMatch(r -> r.getTittle_tconst()
                        .equalsIgnoreCase(rating.getTittle_tconst()));
        if (isAdded) throw new RatingHasBeenAddedException();
        this.ratings.add(rating);
    }


}
