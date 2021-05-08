package ar.edu.unq.desapp.grupoi.backenddesappapi.repositories.review;

import ar.edu.unq.desapp.grupoi.backenddesappapi.model.reviews.Review;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Configuration
@Repository
public interface ReviewRepository extends CrudRepository<Review, String>{

    @Query(value = "SELECT * FROM review", nativeQuery = true)
    List<Review> findAll();

    //List<Review> findAllBy(String tittle_tconst);

    @Query(value ="SELECT * FROM review r WHERE r.tittle_tconst = :tconst", nativeQuery = true)
    List<Review> findReviewsForTitle(@Param("tconst")String tconst);
}
