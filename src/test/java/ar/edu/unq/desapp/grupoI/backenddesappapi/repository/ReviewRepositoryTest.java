package ar.edu.unq.desapp.grupoi.backenddesappapi.repository;

import ar.edu.unq.desapp.grupoi.backenddesappapi.exceptions.ReviewHasBeenAddedException;
import ar.edu.unq.desapp.grupoi.backenddesappapi.model.platform.Platform;
import ar.edu.unq.desapp.grupoi.backenddesappapi.model.reviews.PremiumReview;
import ar.edu.unq.desapp.grupoi.backenddesappapi.model.reviews.PublicReview;
import ar.edu.unq.desapp.grupoi.backenddesappapi.model.user.CommonUserAbs;
import ar.edu.unq.desapp.grupoi.backenddesappapi.model.user.Critic;
import ar.edu.unq.desapp.grupoi.backenddesappapi.model.user.Type_User;
import ar.edu.unq.desapp.grupoi.backenddesappapi.repositories.review.ReviewRepository;
import ar.edu.unq.desapp.grupoi.backenddesappapi.repositories.review.ReviewRepositoryImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ReviewRepositoryTest {

    private ReviewRepository reviewRepository;
    private CommonUserAbs jose;
    private Critic carlos;
    private PublicReview review1;
    private PremiumReview critic1;


    @BeforeEach
    public void setUp(){
        //this.reviewRepository;
        jose = new CommonUserAbs(4,
                Platform.DISNEY_PLUS,
                Type_User.COMMON,
                "Jose1990",
                "Argentina");
        carlos = new Critic(5,
                Platform.DISNEY_PLUS,
                Type_User.CRITIC,
                6 );
        review1 = new PublicReview(
                "review1",
                "muy buena pelicula de Ciencia ficcion",
                "Me parecio una muy buena pelicula",
                3,
                LocalDate.of(2021,4,25),
                "Spanish",
                jose,
                true);

        critic1 = new PremiumReview(
                "critic2",
                "critic resume",
                "critic extended text",
                4, LocalDate.now(),"English",
                carlos,
                carlos.getCritic_id());
    }

    @Test void repositoryAddReview(){
        this.reviewRepository.save(review1);
        assertEquals(1, reviewRepository.findAll().size());
    }
    @Test void repositoryCantAddReview(){
        this.reviewRepository.save(review1);
        assertThrows(ReviewHasBeenAddedException.class, ()-> this.reviewRepository.save(review1));
    }
    @Test void repositoryGetAllReviews(){
        this.reviewRepository.save(review1);
        this.reviewRepository.save(critic1);
        assertEquals(2, reviewRepository.findAll().size());
    }

    @Test void repositoryGetReview(){
        this.reviewRepository.save(review1);
        this.reviewRepository.save(critic1);
       //assertEquals(carlos, reviewRepository.getReviews("critic2").get(0).getUser());
    }

}
