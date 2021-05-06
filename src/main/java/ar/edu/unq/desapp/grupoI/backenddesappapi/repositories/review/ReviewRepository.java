package ar.edu.unq.desapp.grupoi.backenddesappapi.repositories.review;

import ar.edu.unq.desapp.grupoi.backenddesappapi.model.reviews.Review;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Configuration
@Repository
public interface ReviewRepository extends CrudRepository<Review, String>{

    @Query(value = "SELECT * FROM review", nativeQuery = true)
    List<Review> findAll();

    //List<Review> findAllBy(String tittle_tconst);

    Review save(Review review);

}
