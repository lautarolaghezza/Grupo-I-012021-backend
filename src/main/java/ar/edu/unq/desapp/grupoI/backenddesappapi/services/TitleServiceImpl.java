package ar.edu.unq.desapp.grupoi.backenddesappapi.services;


import ar.edu.unq.desapp.grupoi.backenddesappapi.dto.InverseSearchDTO;
import ar.edu.unq.desapp.grupoi.backenddesappapi.exceptions.TitleNotFoundException;
import ar.edu.unq.desapp.grupoi.backenddesappapi.model.films.Classifiable;
import ar.edu.unq.desapp.grupoi.backenddesappapi.model.films.Crew;
import ar.edu.unq.desapp.grupoi.backenddesappapi.model.films.Principals;
import ar.edu.unq.desapp.grupoi.backenddesappapi.model.films.Title;
import ar.edu.unq.desapp.grupoi.backenddesappapi.repositories.TitleRepository;
import ar.edu.unq.desapp.grupoi.backenddesappapi.repositories.films.CrewRepository;
import ar.edu.unq.desapp.grupoi.backenddesappapi.repositories.films.PrincipalsRepository;
import ar.edu.unq.desapp.grupoi.backenddesappapi.repositories.review.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class TitleServiceImpl implements TitleService {

    @Autowired
    private final TitleRepository titleRepository;

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private CrewRepository crewRepository;

    @Autowired
    private PrincipalsRepository principalsRepository;

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
            title.addRating(reviewRepository.findReviewsForTitle(title.getTconst()));
            titles.add(title);
        }
        return titles;
    }

    public List<Title> findReviewsMatch(InverseSearchDTO inverseSearchDTO) {
        Title title = new Title(inverseSearchDTO);
        Crew crew = new Crew(inverseSearchDTO);
        Principals principals = new Principals(inverseSearchDTO);

        Example<Title> titlesExample = Example.of(title, ExampleMatcher.matchingAny());
        Example<Crew> crewExample = Example.of(crew, ExampleMatcher.matchingAny());
        Example<Principals> principalsExample = Example.of(principals, ExampleMatcher.matchingAny());

        List<Title> titles = new ArrayList<>();
        List<Crew> crews = new ArrayList<>();
        List<Principals> principalsList = new ArrayList<>();

        if(!title.allAttrNull()){
            titles = titleRepository.findAll(titlesExample);
        }
        if(!crew.allAttrNull()) {
            crews = crewRepository.findAll(crewExample);
        }

        if(!principals.allAttrNull()) {
            principalsList = principalsRepository.findAll(principalsExample);
        }

        Set<String> tconsts = this.combineTitles(titles,crews,principalsList);

        return iterableToList(titleRepository.findAllById(tconsts));
    }

    private Set<String> combineTitles(List<Title> titles, List<Crew> crews, List<Principals> principalsList) {
        List<String> tconsts = new ArrayList<>();
        for (Title title: titles) {
            tconsts.add(title.getTconst());
        }
        for (Crew crew : crews){
            tconsts.add(crew.getTconst());
        }
        for (Principals princpals: principalsList){
            tconsts.add(princpals.getTconst());
        }

        return findDuplicates(tconsts);
    }

    public Set<String> findDuplicates(List<String> listContainingDuplicates)
    {
        final Set<String> setToReturn = new HashSet<>();
        final Set<String> set1 = new HashSet<>();

        for (String tconst : listContainingDuplicates)
        {
            if (!set1.add(tconst))
            {
                setToReturn.add(tconst);
            }
        }
        return setToReturn;
    }



    @Override
    public Title findById(String id) {
        return titleRepository.findById(id).orElseThrow(TitleNotFoundException::new);
    }
}
