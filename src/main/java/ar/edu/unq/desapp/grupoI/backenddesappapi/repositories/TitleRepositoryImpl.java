package ar.edu.unq.desapp.grupoi.backenddesappapi.repositories;

import ar.edu.unq.desapp.grupoi.backenddesappapi.exceptions.TitleHasBeenAddedException;
import ar.edu.unq.desapp.grupoi.backenddesappapi.exceptions.TitleNotFoundException;
import ar.edu.unq.desapp.grupoi.backenddesappapi.model.films.Title;
import ar.edu.unq.desapp.grupoi.backenddesappapi.model.reviews.Review;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TitleRepositoryImpl {

    List<Title> titles;

    public TitleRepositoryImpl() {
        this.titles = new ArrayList<>();
    }

    public List<Title> getTitles() {
        return titles;
    }


    public Title getTitle(String tconst) {
        Optional<Title> film = titles.stream()
                .filter(f -> f.getTconst().equals(tconst))
                .findFirst();
        return film.orElseThrow(TitleNotFoundException::new);
    }


    public void addTitle(Title title) {
        boolean isAdded = this.titles.stream().anyMatch(t -> t.getTconst().equals(title.getTconst()));
        if (isAdded) throw new TitleHasBeenAddedException();
        titles.add(title);
    }
}
