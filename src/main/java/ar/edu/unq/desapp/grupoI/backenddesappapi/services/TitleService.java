package ar.edu.unq.desapp.grupoi.backenddesappapi.services;

import ar.edu.unq.desapp.grupoi.backenddesappapi.dto.InverseSearchDTO;
import ar.edu.unq.desapp.grupoi.backenddesappapi.dto.SubscribeDTO;
import ar.edu.unq.desapp.grupoi.backenddesappapi.model.films.Classifiable;
import ar.edu.unq.desapp.grupoi.backenddesappapi.model.films.Title;

import java.util.LinkedHashMap;
import java.util.List;

public interface TitleService {

    List<Title> getTitles();

    Title getTitle(String tconst);

    void addTitle(Title title);

    List<Title> findAll();

    public List<Title> findReviewsMatch(InverseSearchDTO inverseSearchDTO);

    Title findById(String id);

    List<Title> searchReverseCriteria(LinkedHashMap<String, String> filters);

    void subscribe(SubscribeDTO subscribeDTO);

    void unsubscribe(SubscribeDTO subscribeDTO);

    List<String> getSubscribers(String tconst);
}
