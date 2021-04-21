package service;

import model.Filter;
import model.FilterType;
import model.Platform;
import model.reviews.PublicReview;
import model.reviews.Review;
import model.user.CommonUser;
import model.user.Type_User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import service.reviewService.ReviewService;
import service.reviewService.ReviewServiceImpl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ReviewServiceTest {
    public ReviewService reviewService;
    public List<Review> reviews;
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

        filterPlatform = new Filter("NETFLIX", FilterType.PLATFORM);
        filterSpoilerAlert = new Filter("TRUE", FilterType.SPOILER_ALERT);
        filterTypeUser1 = new Filter("COMMON",FilterType.TYPE_USER);
        filterTypeUser2 = new Filter("CRITIC",FilterType.TYPE_USER);
        filterLanguage = new Filter("SPANISH", FilterType.LANGUAGE);
        filterLocation = new Filter("ARGENTINA", FilterType.LOCATION);

        reviews = new ArrayList<>();
        juan = new CommonUser(Platform.NETFLIX, Type_User.COMMON,
                "Juancito",
                "Argentina",
                12);
        this.reviewService = new ReviewServiceImpl(reviews);

        review1 = juan.createReview(1,
                "muy buena pelicula de Ciencia ficcion",
                "Me parecio una muy buena pelicula",
                3,
                LocalDate.now(),
                Platform.NETFLIX,
                "Spanish",
                true);
        review2 = juan.createReview(2,
                "muy buena pelicula de Ciencia ficcion",
                "Me parecio una muy buena pelicula",
                3, LocalDate.now(),
                Platform.AMAZON_PREMIUM,
                "Spanish",
                false);
        review3 = juan.createReview(4,
                "cuenta la historia de neo",
                "es muy buena la historia",
                4, LocalDate.now(),
                Platform.DISNEY_PLUS,
                "English",
                false);
        reviewService.addReview(juan, review1);
        reviewService.addReview(juan, review2);
        reviewService.addReview(juan, review3);
        }
    @Test
        public void addReviewTest(){
        PublicReview review3 = juan.createReview(3,
                "muy buena pelicula de Ciencia ficcion",
                "Me parecio una muy buena pelicula",
                3, LocalDate.now(),
                Platform.NETFLIX,
                "Spanish", false);
        reviewService.addReview(juan, review3);
        Assertions.assertEquals(review3.getExtendedText(), reviewService.getReviews(3).get(0).getExtendedText());
    }
    @Test
    public void getReviewsTest(){
        List<Review> result =  reviewService.getReviews(1);
        review1 = juan.createReview(1,
                "muy mala pelicula ",
                "No la olveria a ver por nada",
                1,
                LocalDate.now(),
                Platform.AMAZON_PREMIUM,
                "Spanish",
                false);
        Assertions.assertEquals(1, result.size());
    }

    @Test
    public void getReviewsWithFilterPlatformTest(){
        List<Filter> filters = new ArrayList<>();
        filters.add(filterPlatform);
        List<Review> result = reviewService.getReviewsWithFilter(filters);

        Assertions.assertEquals(1,result.size());

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



}
