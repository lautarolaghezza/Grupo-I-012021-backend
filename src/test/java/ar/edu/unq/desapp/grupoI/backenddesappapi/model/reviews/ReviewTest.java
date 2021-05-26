package ar.edu.unq.desapp.grupoi.backenddesappapi.model.reviews;

import ar.edu.unq.desapp.grupoi.backenddesappapi.model.platform.Platform;
import ar.edu.unq.desapp.grupoi.backenddesappapi.model.user.CommonUserAbs;
import ar.edu.unq.desapp.grupoi.backenddesappapi.model.user.Critic;
import ar.edu.unq.desapp.grupoi.backenddesappapi.model.user.Type_User;
import org.junit.jupiter.api.BeforeEach;

import java.util.Date;

public class ReviewTest {

    private PublicReview publicReview;
    private PremiumReview premiumReview;
    private CommonUserAbs user;
    private Critic critic;


    @BeforeEach
    public void setUp() {
        this.user = new CommonUserAbs(1L,
                Platform.NETFLIX,
                Type_User.COMMON,
                "Jose",
                "AR");
        this.critic = new Critic(12, Platform.NETFLIX,
                Type_User.CRITIC,12);
        this.publicReview = new PublicReview("pdc1",
                "resume",
                "extended text",
                4, new Date(1990,11,6),
                "English", user, false);
        this.premiumReview = new PremiumReview("pdc2", "resume",
                "extended text pdc2", 3,
                new Date(1990,11,6),
                "English", critic, 12);
    }

}
