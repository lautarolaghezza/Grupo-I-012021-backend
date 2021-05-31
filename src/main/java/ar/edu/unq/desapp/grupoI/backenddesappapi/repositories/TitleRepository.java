package ar.edu.unq.desapp.grupoi.backenddesappapi.repositories;

import ar.edu.unq.desapp.grupoi.backenddesappapi.model.films.Title;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Configuration
@Repository
public interface TitleRepository extends JpaRepository<Title, String> {

    List<Title> getTitles();

    Title getTitle(String tconst);

    void addTitle(Title title);
}
