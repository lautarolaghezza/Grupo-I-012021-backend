package ar.edu.unq.desapp.grupoi.backenddesappapi.repositories;

import ar.edu.unq.desapp.grupoi.backenddesappapi.model.films.Title;

import java.util.List;
//@Configuration
//@Repository
public interface TitleRepository {

    List<Title> getTitles();

    Title getTitle(String tconst);

    void addTitle(Title title);
}
