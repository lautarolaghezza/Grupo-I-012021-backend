package service;

import model.rating.Rating;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import service.ratingService.RatingService;
import service.ratingService.RatingServiceImpl;

import static org.junit.Assert.assertEquals;

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
        Assertions.assertEquals("PDC2", ratingService.getAllRatings().get(0).getTconst());
        Assertions.assertEquals(4, ratingService.getAllRatings().get(0).getAverageRating());
        Assertions.assertEquals(5, ratingService.getAllRatings().get(0).getNumVotes());
    }

    @Test
    public void getRatingTest(){
        Assertions.assertEquals("PDC2", ratingService.getRatings("PDC2").get(0).getTconst());
    }

    @Test
    public void addRatingTest(){
        Rating rating2 = new Rating("PDC3", 3, 6);
        ratingService.addRating(rating2);
        Assertions.assertEquals(2, ratingService.getAllRatings().size());
    }
}
