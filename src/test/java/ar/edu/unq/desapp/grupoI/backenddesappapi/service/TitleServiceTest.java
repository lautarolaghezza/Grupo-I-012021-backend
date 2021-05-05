package ar.edu.unq.desapp.grupoi.backenddesappapi.service;

import ar.edu.unq.desapp.grupoi.backenddesappapi.model.films.Title;
import ar.edu.unq.desapp.grupoi.backenddesappapi.repositories.TitleRepository;
import ar.edu.unq.desapp.grupoi.backenddesappapi.services.TitleService;
import ar.edu.unq.desapp.grupoi.backenddesappapi.services.TitleServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doReturn;


public class TitleServiceTest {

    @Mock
    private TitleRepository titleRepository;

    private TitleService titleService;
    private Title title;
    private List<Title> titles;

    @BeforeEach
    public void setUp() {
        titles = new ArrayList<>();
        MockitoAnnotations.initMocks(this);
        this.titleService = new TitleServiceImpl(titleRepository);
        this.title = new Title();
        titles.add(title);

    }

    @Test
    public void titleServiceImplementationCanAddNewTitle() {
        doReturn(titles).when(titleRepository).getTitles();
        String tconst = "PDC2";
        title.setTconst(tconst);
        title.setPrimaryTitle("Piratas del caribe 2");
        titleService.addTitle(title);

        Title title2 = titleService.getTitles().get(0);

        assertEquals(1, titleService.getTitles().size());
        assertEquals(title2.getPrimaryTitle(), title.getPrimaryTitle());
    }

    @Test
    public void titleServiceImplementationCanGetSimpleTitleAdded() {
        String tconst = "PDC2";
        title.setTconst(tconst);
        title.setPrimaryTitle("Piratas del caribe 2");
        titleService.addTitle(title);
        doReturn(title).when(titleRepository).getTitle(tconst);

        Title title2 = titleService.getTitle(tconst);

        assertEquals(title2.getPrimaryTitle(), title.getPrimaryTitle());
    }
}
