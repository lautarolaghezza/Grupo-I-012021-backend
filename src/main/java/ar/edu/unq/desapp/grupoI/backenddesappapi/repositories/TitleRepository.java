package ar.edu.unq.desapp.grupoi.backenddesappapi.repositories;

import ar.edu.unq.desapp.grupoi.backenddesappapi.model.films.Classifiable;
import ar.edu.unq.desapp.grupoi.backenddesappapi.model.films.Title;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Configuration
@Repository
public interface TitleRepository extends JpaRepository<Title, String> {

    List<Title> getTitles();

    Title getTitle(String tconst);

    void addTitle(Title title);
/*
    @Query(value ="SELECT * FROM classifiable t WHERE " +
            "t.title_type LIKE CONCAT('%',:matcher,'%') OR " +
            "t.primary_title LIKE CONCAT('%',:matcher,'%') OR " +
            "t.original_title LIKE CONCAT('%',:matcher,'%') OR " +
            "t.is_adult LIKE CONCAT('%',CAST(:matcher as boolean) ELSE null,'%') OR " +
            "t.start_year LIKE CONCAT('%',CAST(:matcher as integer) ELSE null,'%') OR " +
            "t.end_year LIKE CONCAT('%',CAST(:matcher as integer) ELSE null,'%') OR " +
            "t.runtime_minutes LIKE CONCAT('%',CAST(:matcher as integer) ELSE null,'%') OR " +
            "t.genres LIKE CONCAT('%',:matcher,'%')", nativeQuery = true)

 */
    //List<Classifiable> findReviewsMatch(@Param("matcher")String matcher);

}
