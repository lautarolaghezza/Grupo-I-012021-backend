package ar.edu.unq.desapp.grupoi.backenddesappapi.model.films;

import ar.edu.unq.desapp.grupoi.backenddesappapi.model.rating.Rating;
import ar.edu.unq.desapp.grupoi.backenddesappapi.model.reviews.PremiumReview;
import ar.edu.unq.desapp.grupoi.backenddesappapi.model.reviews.PublicReview;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class EpisodeTest {

    private Episode episode;
    private List<PremiumReview> critics;
    private List<PublicReview> reviews;
    private Crew crew;
    private Principals principals;
    private Rating rating;

    @BeforeEach
    public void setUp() {
        critics = new ArrayList<>();
        reviews = new ArrayList<>();
        crew = new Crew();
        principals = new Principals();
        rating = new Rating();
        crew.setCrewtconst("crew");
        principals.setPrincipaltconst("principals");
        rating.setAverage_rating(4.0);
        this.episode = new Episode("friends-S1E2", "tvSeries-Friends", 1, 2, critics, reviews);
        episode.setCrew(crew);
        episode.setPrincipals(principals);
        episode.setRating(rating);
    }

    @Test
    public void newFriendsEpisodeHasProperties() {
        PremiumReview premiumReview = new PremiumReview();
        critics.add(premiumReview);
        PublicReview publicReview = new PublicReview();
        reviews.add(publicReview);

        assertEquals("friends-S1E2", episode.getTconst());
        assertEquals("tvSeries-Friends", episode.getParentTconst());
        assertEquals(1, episode.getSeasonNumber());
        assertEquals(2, episode.getEpisodeNumber());
        assertEquals(crew, episode.getCrew());
        assertEquals(principals, episode.getPrincipals());
        assertEquals(rating, episode.getRating());
    }

}
