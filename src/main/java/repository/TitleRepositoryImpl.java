package repository;

import exceptions.TitleHasBeenAddedException;
import exceptions.TitleNotFoundException;
import model.films.Title;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TitleRepositoryImpl implements TitleRepository {

    List<Title> titles;

    public TitleRepositoryImpl() {
        this.titles = new ArrayList<>();
    }

    @Override
    public List<Title> getTitles() {
        return titles;
    }

    @Override
    public Title getTitle(String tconst) {
        Optional<Title> film = titles.stream()
                .filter(f -> f.getTconst().equals(tconst))
                .findFirst();
        return film.orElseThrow(TitleNotFoundException::new);
    }

    @Override
    public void addTitle(Title title) {
        boolean isAdded = this.titles.stream().anyMatch(t -> t.getTconst().equals(title.getTconst()));
        if(isAdded) throw new TitleHasBeenAddedException();
        titles.add(title);
    }
}
