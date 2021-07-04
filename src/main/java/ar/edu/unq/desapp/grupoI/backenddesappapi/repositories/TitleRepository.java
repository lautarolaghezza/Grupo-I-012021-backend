package ar.edu.unq.desapp.grupoi.backenddesappapi.repositories;

import ar.edu.unq.desapp.grupoi.backenddesappapi.model.films.Classifiable;
import ar.edu.unq.desapp.grupoi.backenddesappapi.model.films.Title;
import ar.edu.unq.desapp.grupoi.backenddesappapi.model.reviews.Review;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Configuration
@Repository
public interface TitleRepository extends JpaRepository<Title, String> {

    List<Title> getTitles();

    Title getTitle(String tconst);

    void addTitle(Title title);

    @Query(value ="SELECT * FROM classifiable c WHERE c.originañ_titlw LIKE %:textSearch%", nativeQuery = true)
    List<Classifiable> findTitle(@Param("textSearch")String textSearch);
}
