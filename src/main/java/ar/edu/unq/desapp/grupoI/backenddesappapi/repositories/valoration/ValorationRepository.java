package ar.edu.unq.desapp.grupoi.backenddesappapi.repositories.valoration;

import ar.edu.unq.desapp.grupoi.backenddesappapi.model.valoration.Valoration;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Configuration
@Repository
public interface ValorationRepository extends JpaRepository<Valoration, Long> {




    @Query(value = "SELECT * FROM valoration v where v.review_id = :review_id", nativeQuery = true)
    List<Valoration> findByReview_id(@Param("review_id") Long review_id);

}
