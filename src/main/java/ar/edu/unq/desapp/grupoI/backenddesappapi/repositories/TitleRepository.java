package ar.edu.unq.desapp.grupoi.backenddesappapi.repositories;

import ar.edu.unq.desapp.grupoi.backenddesappapi.model.films.Title;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Configuration
@Repository
public interface TitleRepository extends CrudRepository<Title, String> {

    List<Title> getTitles();

    Title getTitle(String tconst);

    void addTitle(Title title);

    @Query(value ="SELECT * FROM tittle t WHERE " +
            "t.titleType LIKE CONCAT('%',:matcher,'%') OR " +
            "t.primaryTitle LIKE CONCAT('%',:matcher,'%')OR " +
            "t.originalTitle LIKE CONCAT('%',:matcher,'%') OR " +
            "t.isAdult LIKE CONCAT('%',:matcher,'%') OR " +
            "t.startYear LIKE CONCAT('%',:matcher,'%') OR " +
            "t.endYear LIKE CONCAT('%',:matcher,'%') OR " +
            "t.runtimeMinutes LIKE CONCAT('%',:matcher,'%')OR " +
            "t.genres LIKE CONCAT('%',:matcher,'%')", nativeQuery = true)
    List<Title> findReviewsMatch(@Param("matcher")String matcher);

}
