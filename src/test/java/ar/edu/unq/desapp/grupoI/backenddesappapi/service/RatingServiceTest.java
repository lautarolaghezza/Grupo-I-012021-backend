package ar.edu.unq.desapp.grupoi.backenddesappapi.service;

import ar.edu.unq.desapp.grupoi.backenddesappapi.model.rating.Rating;
import ar.edu.unq.desapp.grupoi.backenddesappapi.services.ratingService.RatingService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

public class RatingServiceTest {

    @Mock
    private RatingService ratingService;

    @BeforeEach
    public void setUp(){
        Rating rating = new Rating("PDC2", 4.0, 5);
        this.ratingService = new RatingService();
        this.ratingService.addRating(rating);

    }

    @Test
    public void getAllRatingsTest(){
        Assertions.assertEquals(1, ratingService.getAllRatings().size());
        Assertions.assertEquals("PDC2", ratingService.getAllRatings().get(0).getTittle_tconst());
        Assertions.assertEquals(4, ratingService.getAllRatings().get(0).getAverage_rating());
        Assertions.assertEquals(5, ratingService.getAllRatings().get(0).getNum_votes());
    }

    @Test
    public void getRatingTest(){
        Assertions.assertEquals("PDC2", ratingService.getRatingById("PDC2").getTittle_tconst());
    }

    @Test
    public void addRatingTest(){
        Rating rating2 = new Rating("PDC3", 3.0, 6);
        ratingService.addRating(rating2);
        Assertions.assertEquals(2, ratingService.getAllRatings().size());
    }
}
