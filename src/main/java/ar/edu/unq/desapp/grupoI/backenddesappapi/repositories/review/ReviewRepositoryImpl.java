package ar.edu.unq.desapp.grupoi.backenddesappapi.repositories.review;


import ar.edu.unq.desapp.grupoi.backenddesappapi.exceptions.ReviewHasBeenAddedException;
import ar.edu.unq.desapp.grupoi.backenddesappapi.model.reviews.Review;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ReviewRepositoryImpl {

    List<Review> reviews;

    public ReviewRepositoryImpl() {
        this.reviews = new ArrayList<>();
    }


    public List<Review> findAll() {
        return this.reviews;
    }

    public List<Review> getReviews(String tittle_tconst) {
        return reviews.stream()
                .filter( r -> r.getTittle_tconst().equalsIgnoreCase(tittle_tconst))
                .collect(Collectors
                .toList());
    }


    public Review save(Review review) {
        boolean isAdded = this.reviews.stream().anyMatch(r -> r.getTittle_tconst().equalsIgnoreCase(review.getTittle_tconst()));
        if (isAdded) throw new ReviewHasBeenAddedException();
        this.reviews.add(review);
        return review;
    }

}
