package ar.edu.unq.desapp.grupoi.backenddesappapi.services;

import ar.edu.unq.desapp.grupoi.backenddesappapi.model.films.Title;

import java.util.List;

public interface TitleService {

    List<Title> getTitles();

    Title getTitle(String tconst);

    void addTitle(Title title);
}
