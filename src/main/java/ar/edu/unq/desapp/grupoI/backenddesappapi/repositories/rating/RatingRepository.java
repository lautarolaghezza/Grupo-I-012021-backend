package ar.edu.unq.desapp.grupoi.backenddesappapi.repositories.rating;

import ar.edu.unq.desapp.grupoi.backenddesappapi.model.rating.Rating;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Configuration
@Repository
public interface RatingRepository extends JpaRepository<Rating, String> {

    @Query(value ="SELECT * FROM rating r WHERE r.tittle_tconst = :tittle_tconst", nativeQuery = true)
    Rating findAllById(@Param("tittle_tconst")String tittle_tconst);
}
