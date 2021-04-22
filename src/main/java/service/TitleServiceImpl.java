package service;

import model.films.Title;
import org.springframework.beans.factory.annotation.Autowired;
import repository.TitleRepository;

import java.util.List;

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
}
