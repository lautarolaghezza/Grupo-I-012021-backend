package repository;

import model.films.Title;

import java.util.List;

public interface TitleRepository {

    List<Title> getTitles();

    Title getTitle(String tconst);

    void addTitle(Title title);
}
