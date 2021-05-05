package ar.edu.unq.desapp.grupoi.backenddesappapi.repository;

import ar.edu.unq.desapp.grupoi.backenddesappapi.exceptions.RatingHasBeenAddedException;
import ar.edu.unq.desapp.grupoi.backenddesappapi.model.rating.Rating;
import ar.edu.unq.desapp.grupoi.backenddesappapi.repositories.rating.RatingRepository;
import ar.edu.unq.desapp.grupoi.backenddesappapi.repositories.rating.RatingRepositoryImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RatingRepositoryTest {

    private RatingRepository ratingRepository;
    private Rating rating;
    private Rating rating2;
    @BeforeEach
    public void setUp(){
        this.ratingRepository= new RatingRepositoryImpl();
        rating = new Rating("rating1",3,1);
        rating2 = new Rating("rating2",2,2);
        ratingRepository.addRating(rating);

    }

    @Test void repositoryAddRating(){
        ratingRepository.addRating(rating2);
        assertEquals(rating2.getTconst(), ratingRepository.getRating("rating2").get(0).getTconst());
    }
    @Test void repositoryCantAddRating(){
        assertThrows(RatingHasBeenAddedException.class, ()-> this.ratingRepository.addRating(rating));
    }
    @Test void repositoryGetAllRatings(){
        assertEquals(1, ratingRepository.getRatings().size());
    }

    @Test void repositoryGetRating(){
        assertEquals(rating.getTconst(), ratingRepository.getRating("rating1").get(0).getTconst());
    }

}
