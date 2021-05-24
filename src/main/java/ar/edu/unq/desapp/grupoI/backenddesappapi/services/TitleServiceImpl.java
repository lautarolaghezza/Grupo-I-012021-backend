package ar.edu.unq.desapp.grupoi.backenddesappapi.services;


import ar.edu.unq.desapp.grupoi.backenddesappapi.exceptions.TitleNotFoundException;
import ar.edu.unq.desapp.grupoi.backenddesappapi.model.films.Title;
import ar.edu.unq.desapp.grupoi.backenddesappapi.model.reviews.Review;
import ar.edu.unq.desapp.grupoi.backenddesappapi.repositories.TitleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TitleServiceImpl implements TitleService {

    @Autowired
    private final TitleRepository titleRepository;

    public TitleServiceImpl(TitleRepository titleRepository) {
        this.titleRepository = titleRepository;
    }

    @Override
    public List<Title> getTitles() {
        return titleRepository.getTitles();
    }

    @Override
    public Title getTitle(String tconst) {
        return titleRepository.getTitle(tconst);
    }

    @Override
    public void addTitle(Title title) {
        titleRepository.addTitle(title);
    }

    @Override
    public List<Title> findAll() {
        return iterableToList(titleRepository.findAll());
    }

    private List<Title> iterableToList(Iterable<Title> iterable){
        List<Title> titles = new ArrayList<>();
        for (Title title : iterable) {
            titles.add(title);
        }
        return titles;
    }

    @Override
    public List<Title> findReviewsMatch(String matcher) {
        return titleRepository.findReviewsMatch(matcher);
    }

    @Override
    public Title findById(String id) {
        return titleRepository.findById(id).orElseThrow(TitleNotFoundException::new);
    }
}
