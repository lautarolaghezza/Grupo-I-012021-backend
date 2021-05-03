package service.ratingService;

import lombok.Getter;
import model.rating.Rating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.rating.RatingRepository;
import repository.rating.RatingRepositoryImpl;

import java.util.List;

@Getter
@Service
public class RatingServiceImpl implements RatingService {

    @Autowired
    private RatingRepository ratingRepository;

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
