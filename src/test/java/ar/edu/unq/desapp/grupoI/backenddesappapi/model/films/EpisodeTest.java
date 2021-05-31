package ar.edu.unq.desapp.grupoi.backenddesappapi.model.films;

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

    @BeforeEach
    public void setUp() {
        critics = new ArrayList<>();
        reviews = new ArrayList<>();
        this.episode = new Episode("friends-S1E2", "tvSeries-Friends", 1, 2, critics, reviews);
    }

    @Test
    public void newFriendsEpisodeOfSeason2CanGetHisRankingWithOneCriticWith5AndOtherWith4() {
        PremiumReview premiumReview = new PremiumReview();
        //premiumReview.setRating(5);
        critics.add(premiumReview);
        PublicReview publicReview = new PublicReview();
        //publicReview.setRating(4);
        reviews.add(publicReview);

        assertEquals(4.5, this.episode.getRating());
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
        //assertTrue(episode.getCritics().contains(premiumReview));
        //assertTrue(episode.getReviews().contains(publicReview));
    }

}
