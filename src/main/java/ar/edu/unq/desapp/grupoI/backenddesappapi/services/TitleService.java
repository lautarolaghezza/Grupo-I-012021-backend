package ar.edu.unq.desapp.grupoi.backenddesappapi.services;

import ar.edu.unq.desapp.grupoi.backenddesappapi.dto.InverseSearchDTO;
import ar.edu.unq.desapp.grupoi.backenddesappapi.model.films.Classifiable;
import ar.edu.unq.desapp.grupoi.backenddesappapi.model.films.Title;
import ar.edu.unq.desapp.grupoi.backenddesappapi.model.reviews.Review;

import java.util.List;

public interface TitleService {

    List<Title> getTitles();

    Title getTitle(String tconst);

    void addTitle(Title title);

    List<Title> findAll();

    public List<Title> findReviewsMatch(InverseSearchDTO inverseSearchDTO);

    Title findById(String id);
}
