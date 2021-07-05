package ar.edu.unq.desapp.grupoi.backenddesappapi.services;

import ar.edu.unq.desapp.grupoi.backenddesappapi.model.films.TitleCache;
import ar.edu.unq.desapp.grupoi.backenddesappapi.repositories.films.TitleCacheRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class TitleCacheService {

    @Autowired
    TitleCacheRepository titleCacheRepository;

    public List<TitleCache> findAll() {
        List<TitleCache> titles = new ArrayList<>();
        titleCacheRepository.findAll().forEach(titles::add);
        return titles;
    }
}
