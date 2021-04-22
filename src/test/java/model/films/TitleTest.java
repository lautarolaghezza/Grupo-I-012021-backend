package model.films;

import model.reviews.PremiumReview;
import model.reviews.PublicReview;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TitleTest {

    private Title title;
    private List<PremiumReview> critics;
    private List<PublicReview> reviews;

    @BeforeEach
    public void setUp() {
        this.critics = new ArrayList<>();
        this.reviews = new ArrayList<>();
        List<String> genres = new ArrayList<>();
        genres.add("action");
        this.title = new Title("pdc1", "movie", "Piratas del caribe",
                "Pirates of the caribbean", false, 2003, null,
                143, genres, critics, reviews);
    }

    @Test
    public void newMovieHasIdPDC1() {
        assertEquals("pdc1", title.getTconst());
    }

    @Test
    public void moviePDCHasNewPublicReviewWith4Stars() {
        PublicReview publicReview = new PublicReview();
        publicReview.setRating(4);
        reviews.add(publicReview);

        assertEquals(4, title.getRating());
    }

    @Test
    public void moviePDCHasNewPublicReviewWith4StarsIfHaveOneReviewWith5AndOtherWith3() {
        PublicReview publicReview = new PublicReview();
        publicReview.setRating(3);
        PremiumReview premiumReview = new PremiumReview();
        premiumReview.setRating(5);
        reviews.add(publicReview);
        critics.add(premiumReview);

        assertEquals(4, title.getRating());
    }

    @Test
    public void moviePDCHasNewPublicReviewWith2p5StarsIfHaveOneReviewWith5AndOtherWith0() {
        PublicReview publicReview = new PublicReview();
        publicReview.setRating(0);
        PremiumReview premiumReview = new PremiumReview();
        premiumReview.setRating(5);
        reviews.add(publicReview);
        critics.add(premiumReview);

        assertEquals(2.5, title.getRating());
    }

}
