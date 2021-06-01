package ar.edu.unq.desapp.grupoi.backenddesappapi.service;

import ar.edu.unq.desapp.grupoi.backenddesappapi.model.rating.Rating;
import ar.edu.unq.desapp.grupoi.backenddesappapi.services.ratingService.RatingService;
import ar.edu.unq.desapp.grupoi.backenddesappapi.services.ratingService.RatingServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

public class RatingServiceTest {

    @Mock
    private RatingService ratingService;

    @BeforeEach
    public void setUp(){
        Rating rating = new Rating("PDC2", 4, 5);
        this.ratingService = new RatingServiceImpl();
        this.ratingService.addRating(rating);

    }

    @Test
    public void getAllRatingsTest(){
        Assertions.assertEquals(1, ratingService.getAllRatings().size());
        Assertions.assertEquals("PDC2", ratingService.getAllRatings().get(0).getTittle_tconst());
        Assertions.assertEquals(4, ratingService.getAllRatings().get(0).getAverageRating());
        Assertions.assertEquals(5, ratingService.getAllRatings().get(0).getNumVotes());
    }

    @Test
    public void getRatingTest(){
        Assertions.assertEquals("PDC2", ratingService.getRatings("PDC2").get(0).getTittle_tconst());
    }

    @Test
    public void addRatingTest(){
        Rating rating2 = new Rating("PDC3", 3, 6);
        ratingService.addRating(rating2);
        Assertions.assertEquals(2, ratingService.getAllRatings().size());
    }
}
