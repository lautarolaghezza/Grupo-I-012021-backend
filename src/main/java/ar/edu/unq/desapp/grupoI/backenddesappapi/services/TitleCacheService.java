package ar.edu.unq.desapp.grupoi.backenddesappapi.services;

import ar.edu.unq.desapp.grupoi.backenddesappapi.model.films.Title;
import ar.edu.unq.desapp.grupoi.backenddesappapi.model.films.TitleCache;
import ar.edu.unq.desapp.grupoi.backenddesappapi.repositories.TitleRepository;
import ar.edu.unq.desapp.grupoi.backenddesappapi.repositories.films.TitleCacheRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class TitleCacheService {

    @Autowired
    TitleCacheRepository titleCacheRepository;

    @Autowired
    TitleRepository titleRepository;

    public List<TitleCache> findAll() {
        List<TitleCache> titles = new ArrayList<>();
        titleCacheRepository.findAll().forEach(titles::add);
        return titles;
    }

    @Scheduled(fixedRate = 300000)
    public void setNewsTitles(){
        List<Title> titles = titleRepository.findAll();
        List<TitleCache> titlesCache = new ArrayList<>();
        for (Title title : titles) {
            titlesCache.add(titleToCache(title));
        }
        titleCacheRepository.saveAll(titlesCache);
    }

    private TitleCache titleToCache(Title title) {
        TitleCache titleCache = new TitleCache();
        titleCache.setRating(title.getRating().getAverage_rating());
        titleCache.setTconst(title.getTconst());
        titleCache.setVotes(title.getRating().getNum_votes());
        return titleCache;
    }
}
