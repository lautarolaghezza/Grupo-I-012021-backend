package repository.review;

import exceptions.ReviewHasBeenAddedException;
import lombok.SneakyThrows;
import model.reviews.Review;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class ReviewRepositoryImpl implements  ReviewRepository{

    List<Review> reviews;

    public ReviewRepositoryImpl() {
        this.reviews = new ArrayList<>();
    }

    @Override
    public List<Review> getReviews() {
        return this.reviews;
    }

    @Override
    public List<Review> getReviews(String tittle_tconst) {
        return reviews.stream()
                .filter( r -> r.getTittle_tconst().equalsIgnoreCase(tittle_tconst))
                .collect(Collectors
                .toList());
    }

    @SneakyThrows
    @Override
    public void addReview(Review review) {
        boolean isAdded = this.reviews.stream().anyMatch(r -> r.getTittle_tconst().equalsIgnoreCase(review.getTittle_tconst()));
        if (isAdded) throw new ReviewHasBeenAddedException();
        this.reviews.add(review);
    }
}
