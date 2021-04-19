package service;

import model.films.Title;

import java.util.List;

public interface TitleService {

    public List<Title> getTitles();
    public Title getTitle(String tconst);
    public void addTitle(Title title);

}
