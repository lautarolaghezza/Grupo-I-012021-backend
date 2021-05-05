package ar.edu.unq.desapp.grupoi.backenddesappapi.repository;

import ar.edu.unq.desapp.grupoi.backenddesappapi.exceptions.TitleHasBeenAddedException;
import ar.edu.unq.desapp.grupoi.backenddesappapi.exceptions.TitleNotFoundException;
import ar.edu.unq.desapp.grupoi.backenddesappapi.model.films.Title;
import ar.edu.unq.desapp.grupoi.backenddesappapi.repositories.TitleRepositoryImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TitleRepositoryTest {

    private TitleRepositoryImpl titleRepository;

    @BeforeEach
    public void setUp() {
        this.titleRepository = new TitleRepositoryImpl();
    }


    @Test
    public void repositoryCanAddTitleAndObtainWithId() {
        String stconst = "PDC2";
        Title title = new Title();
        title.setTconst(stconst);
        title.setPrimaryTitle("Piratas del caribe 2");

        this.titleRepository.addTitle(title);
        Title title2 = this.titleRepository.getTitle(stconst);
        assertEquals(title.getPrimaryTitle(), title2.getPrimaryTitle());
        assertEquals(1, this.titleRepository.getTitles().size());
    }

    @Test
    public void repositoryFindTitleButNotFoundIt() {
        assertThrows(TitleNotFoundException.class, () -> {
            this.titleRepository.getTitle("fail");
        });
    }

    @Test
    public void repositoryTryToAddTitleButItHasBeenAddedBefore() {
        String tconst = "PDC2";
        Title title = new Title();
        title.setTconst(tconst);
        title.setPrimaryTitle("Piratas del caribe 2");
        Title title2 = new Title();
        title2.setTconst(tconst);

        this.titleRepository.addTitle(title);

        assertThrows(TitleHasBeenAddedException.class, () -> {
            this.titleRepository.addTitle(title2);
        });
        assertEquals(1, titleRepository.getTitles().size());

    }


}
