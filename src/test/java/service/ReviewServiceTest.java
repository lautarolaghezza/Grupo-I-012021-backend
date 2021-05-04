package service;


import exceptions.ReviewsNotFoundException;
import model.filter.*;
import model.platform.Platform;
import model.reviews.PublicReview;
import model.reviews.Review;
import model.user.CommonUser;
import model.user.Type_User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import service.reviewService.ReviewServiceImpl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class ReviewServiceTest {
    public ReviewServiceImpl reviewService;
    public PublicReview review1;
    public PublicReview review2;
    public PublicReview review3;
    public CommonUser juan;
    public Filter filterPlatform;
    public Filter filterSpoilerAlert;
    public Filter filterTypeUser1;
    public Filter filterTypeUser2;
    public Filter filterLanguage;
    public Filter filterLocation;

    @BeforeEach
    public void setUp(){

        filterPlatform = new PlatformFilter(Platform.NETFLIX);
        filterSpoilerAlert = new SpoilerAlertFilter(true);
        filterTypeUser1 = new TypeUserFilter(Type_User.COMMON);
        filterTypeUser2 = new TypeUserFilter(Type_User.CRITIC);
        filterLanguage = new LanguageFilter("SPANISH");
        filterLocation = new LocationFilter("ARGENTINA");

        juan = new CommonUser(1, Platform.NETFLIX, Type_User.COMMON,
                "Juancito",
                "Argentina");
        this.reviewService = new ReviewServiceImpl();

        review1 = juan.createReview(
                "review1",
                "muy buena pelicula de Ciencia ficcion",
                "Me parecio una muy buena pelicula",
                3,
                LocalDate.of(2021,4,25),
                "Spanish",
                true);
        review2 = juan.createReview(
                "review2",
                "muy buena pelicula de Ciencia ficcion",
                "Me parecio una muy buena pelicula",
                5, LocalDate.of(2000,12,24),
                "Spanish",
                false);
        review3 = juan.createReview(
                "review3",
                "cuenta la historia de neo",
                "es muy buena la historia",
                4, LocalDate.of(1990,11,5),
                "English",
                false);
        reviewService.addReview(juan, review1);
        reviewService.addReview(juan, review2);
        reviewService.addReview(juan, review3);
        }
    @Test
        public void addReviewTest(){
        PublicReview review4 = juan.createReview(
                "review4",
                "muy buena pelicula de Ciencia ficcion",
                "Me parecio una muy buena pelicula",
                3, LocalDate.now(),
                "Spanish", false);
        reviewService.addReview(juan, review4);
        Assertions.assertEquals(review3.getExtendedText(), reviewService.getReviews("review3").get(0).getExtendedText());
    }

    @Test
    public void getReviewsTest(){
        List<Review> result =  reviewService.getReviews("review1");
        review1 = juan.createReview(
                "review1",
                "muy mala pelicula ",
                "No la olveria a ver por nada",
                1,
                LocalDate.now(),
                "Spanish",
                false);
        Assertions.assertEquals(1, result.size());
    }

    @Test
    public void getReviewsWithFilterPlatformTest(){
        List<Filter> filters = new ArrayList<>();
        filters.add(filterPlatform);
        List<Review> result = reviewService.getReviewsWithFilter(filters);

        Assertions.assertEquals(3,result.size());

    }

    @Test
    public void getReviewsWithFilterLocationTest(){
        List<Filter> filters = new ArrayList<>();
        filters.add(filterLocation);
        List<Review> result = reviewService.getReviewsWithFilter(filters);

        Assertions.assertEquals(3,result.size());

    }

    @Test
    public void getReviewsWithFilter_spoiler_alertTest(){
        List<Filter> filters = new ArrayList<>();
        filters.add(filterSpoilerAlert);
        List<Review> result = reviewService.getReviewsWithFilter(filters);

        Assertions.assertEquals(1,result.size());

    }

    @Test
    public void getReviewsWithFilter_type_UserTest(){
        List<Filter> filters = new ArrayList<>();
        filters.add(filterTypeUser1);
        List<Review> result = reviewService.getReviewsWithFilter(filters);

        Assertions.assertEquals(3,result.size());

    }
    @Test
    public void getReviewsWithFilter_languageTest(){
        List<Filter> filters = new ArrayList<>();
        filters.add(filterLanguage);
        List<Review> result = reviewService.getReviewsWithFilter(filters);

        Assertions.assertEquals(2,result.size());

    }

    @Test
    public void orderByRatingAscTest(){
       List<Review> result = reviewService.orderByRatingAsc(reviewService.getAllReviews());
       Assertions.assertEquals(3, result.get(0).getRating());
    }

    @Test
    public void orderByRatingDescTest(){
        List<Review> result = reviewService.orderByRatingDesc(reviewService.getAllReviews());
        Assertions.assertEquals(5, result.get(0).getRating());

    }

    @Test
    public void orderByDateAscTest(){
        List<Review> result = reviewService.orderByDateAsc(reviewService.getAllReviews());
        Assertions.assertEquals(LocalDate.of(1990,11,5), result.get(0).getDate());

    }

    @Test
    public void orderByDateDescTest(){
        List<Review> result = reviewService.orderByDateDesc(reviewService.getAllReviews());
        Assertions.assertEquals(LocalDate.of(2021,4,25), result.get(0).getDate());

    }

    @Test
    public void reviewNotFoundTest(){
        assertThrows(ReviewsNotFoundException.class, ()-> this.reviewService.getReviews("not found"));
    }

    @Test
    public void repositorityNotNull(){
        Assertions.assertNotNull(reviewService.getReviewRepository());
    }
}
