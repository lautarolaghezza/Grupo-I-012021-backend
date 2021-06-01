package ar.edu.unq.desapp.grupoi.backenddesappapi.repositories.review;

import ar.edu.unq.desapp.grupoi.backenddesappapi.model.reviews.Review;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Configuration
@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {


    @Query(value ="SELECT * FROM review r WHERE r.tittle_tconst = :tconst", nativeQuery = true)
    List<Review> findReviewsForTitle(@Param("tconst")String tconst);
}
