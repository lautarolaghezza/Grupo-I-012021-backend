package ar.edu.unq.desapp.grupoi.backenddesappapi.services;


import ar.edu.unq.desapp.grupoi.backenddesappapi.dto.InverseSearchDTO;
import ar.edu.unq.desapp.grupoi.backenddesappapi.dto.SubscribeDTO;
import ar.edu.unq.desapp.grupoi.backenddesappapi.exceptions.TitleNotFoundException;
import ar.edu.unq.desapp.grupoi.backenddesappapi.exceptions.UserAlreadySubsribedException;
import ar.edu.unq.desapp.grupoi.backenddesappapi.model.films.Crew;
import ar.edu.unq.desapp.grupoi.backenddesappapi.model.films.Principals;
import ar.edu.unq.desapp.grupoi.backenddesappapi.model.films.Title;
import ar.edu.unq.desapp.grupoi.backenddesappapi.model.rating.Rating;
import ar.edu.unq.desapp.grupoi.backenddesappapi.model.reviews.TitleSubscribers;
import ar.edu.unq.desapp.grupoi.backenddesappapi.repositories.TitleRepository;
import ar.edu.unq.desapp.grupoi.backenddesappapi.repositories.films.CrewRepository;
import ar.edu.unq.desapp.grupoi.backenddesappapi.repositories.films.PrincipalsRepository;
import ar.edu.unq.desapp.grupoi.backenddesappapi.repositories.review.SubscribeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.*;
import javax.transaction.Transactional;
import java.util.*;

@Service
public class TitleServiceImpl implements TitleService {

    @Autowired
    private final TitleRepository titleRepository;

    @Autowired
    private SubscribeRepository subscribeRepository;

    @Autowired
    private CrewRepository crewRepository;

    @Autowired
    private PrincipalsRepository principalsRepository;

    @PersistenceContext
    EntityManager em;

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

    private List<Title> iterableToList(Iterable<Title> iterable) {
        List<Title> titles = new ArrayList<>();
        for (Title title : iterable) {
            //title.addRating(reviewRepository.findReviewsForTitle(title.getTconst()));
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

        if (!title.allAttrNull()) {
            titles = titleRepository.findAll(titlesExample);
        }
        if (!crew.allAttrNull()) {
            crews = crewRepository.findAll(crewExample);
        }

        if (!principals.allAttrNull()) {
            principalsList = principalsRepository.findAll(principalsExample);
        }

        Set<String> tconsts = this.combineTitles(titles, crews, principalsList);

        return iterableToList(titleRepository.findAllById(tconsts));
    }

    private Set<String> combineTitles(List<Title> titles, List<Crew> crews, List<Principals> principalsList) {
        List<String> titleTconsts = new ArrayList<>();
        List<String> principalTconsts = new ArrayList<>();
        List<String> writersTconsts = new ArrayList<>();
        for (Title title : titles) {
            titleTconsts.add(title.getTconst());
        }
        for (Crew crew : crews) {
            principalTconsts.add(crew.getCrewtconst());
        }
        for (Principals princpals : principalsList) {
            writersTconsts.add(princpals.getPrincipaltconst());
        }
        return intersection(titleTconsts, principalTconsts, writersTconsts);
    }

    private Set<String> intersection(List<String>... titlesToJoin) {
        List<List<String>> titles = new ArrayList<>();
        for (List<String> tconstList : titlesToJoin) {
            if (!tconstList.isEmpty()) titles.add(tconstList);
        }

        Set<String> intersectionTitles = new HashSet<>(titles.get(0));
        for (int i = 1; i < titles.size(); i++) {
            HashSet<String> set = new HashSet<>(titles.get(i));
            intersectionTitles.retainAll(set);
        }

        return intersectionTitles;
    }

    @Override
    public Title findById(String id) {
        return titleRepository.findById(id).orElseThrow(() -> new TitleNotFoundException(HttpStatus.BAD_REQUEST));
    }

    @Transactional
    @Override
    public List<Title> searchReverseCriteria(LinkedHashMap<String, String> filters) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Title> cq = cb.createQuery(Title.class);

        Root<Title> titleRoot = cq.from(Title.class);

        Join<Title, Principals> tittlePrincipalJoin = titleRoot.join("principals");
        Join<Title, Crew> tittleCrewJoin = titleRoot.join("crew");
        Join<Title, Rating> ratingJoin = titleRoot.join("rating");

        List<Predicate> predicates = new ArrayList<>();

        filters.keySet().forEach( key -> {
            switch (key) {
                case "directors":
                    predicates.add(cb.like(tittleCrewJoin.get("directors"), "%" + filters.get("directors") + "%" ));
                    break;
                case "writers":
                    predicates.add(cb.like(tittleCrewJoin.get("writers"), "%" + filters.get("writers") + "%"));
                    break;
                case "ordering":
                    predicates.add(cb.equal(tittlePrincipalJoin.get("ordering"), filters.get("ordering")));
                    break;
                case "nconst":
                    predicates.add(cb.equal(tittlePrincipalJoin.get("nconst"), filters.get("nconst")));
                    break;
                case "category":
                    predicates.add(cb.equal(tittlePrincipalJoin.get("category"), filters.get("category")));
                    break;
                case "job":
                    predicates.add(cb.equal(tittlePrincipalJoin.get("job"), filters.get("job")));
                    break;
                case "characters":
                    predicates.add(cb.like(tittlePrincipalJoin.get("characters"), "%" + filters.get("characters") + "%" ));
                    break;
                case "startYear":
                    predicates.add(cb.equal(titleRoot.get("startYear"), filters.get("startYear")));
                    break;
                case "endYear":
                    predicates.add(cb.equal(titleRoot.get("endYear"), filters.get("endYear")));
                    break;
                case "runtimeMinutes":
                    predicates.add(cb.equal(titleRoot.get("runtimeMinutes"), filters.get("runtimeMinutes")));
                    break;
                case "ratingThan":
                    predicates.add(cb.gt(ratingJoin.get("average_rating"), Double.parseDouble(filters.get("ratingThan"))));
                    break;
                case "ratingLess":
                    predicates.add(cb.lt(ratingJoin.get("average_rating"), Double.parseDouble(filters.get("ratingLess"))));
                    break;
                case "rating":
                    predicates.add(cb.equal(ratingJoin.get("average_rating"), filters.get("rating")));
                    break;
                case "isAdult":
                    predicates.add(cb.equal(titleRoot.get("isAdult"), filters.get("isAdult").equalsIgnoreCase("true")));
                    break;
                default:
                    predicates.add(cb.like(titleRoot.get(key), "%" + filters.get(key) +"%" ));
                    break;
            }
        });
        cq.where(predicates.toArray(new Predicate[0]));

        return em.createQuery(cq).getResultList();
    }

    @Transactional
    @Override
    public void subscribe(SubscribeDTO subscribeDTO) {
        TitleSubscribers subscribers = new TitleSubscribers(new ArrayList<>(), subscribeDTO.getTconst());
        if(subscribeRepository.existsById(subscribeDTO.getTconst())) {
            subscribers = subscribeRepository.getOne(subscribeDTO.getTconst());
        }
        if(subscribers.getUsers().contains(subscribeDTO.getNick())) {
            throw new UserAlreadySubsribedException(HttpStatus.BAD_REQUEST);
        }
        subscribers.getUsers().add(subscribeDTO.getNick());
        subscribeRepository.save(subscribers);
    }

    @Transactional
    @Override
    public void unsubscribe(SubscribeDTO subscribeDTO) {
        TitleSubscribers subscribers = subscribeRepository.getOne(subscribeDTO.getTconst());
        subscribers.getUsers().remove(subscribeDTO.getNick());
        subscribeRepository.save(subscribers);
    }

    @Transactional
    @Override
    public List<String> getSubscribers(String tconst) {
        return subscribeRepository.getOne(tconst).getUsers();
    }

}
