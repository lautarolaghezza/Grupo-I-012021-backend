package ar.edu.unq.desapp.grupoi.backenddesappapi.repositories.review;


import ar.edu.unq.desapp.grupoi.backenddesappapi.exceptions.ReviewHasBeenAddedException;
import ar.edu.unq.desapp.grupoi.backenddesappapi.model.reviews.Review;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class ReviewRepositoryImpl {

    List<Review> reviews;
    private EntityManager em;

    public ReviewRepositoryImpl(EntityManager em) {
        this.em = em;
    }
    public ReviewRepositoryImpl() {
        this.reviews = new ArrayList<>();
    }

    public List<Review> getReviews(String tittle_tconst) {
        return reviews.stream()
                .filter( r -> r.getTittle_tconst().equalsIgnoreCase(tittle_tconst))
                .collect(Collectors
                .toList());
    }

/*
    public Review save(Review review) {
        boolean isAdded = this.reviews.stream().anyMatch(r -> r.getTittle_tconst().equalsIgnoreCase(review.getTittle_tconst()));
        if (isAdded) throw new ReviewHasBeenAddedException();
        this.reviews.add(review);
        return review;
    }*/

}
