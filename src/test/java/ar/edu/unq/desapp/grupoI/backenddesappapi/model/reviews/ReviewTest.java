package ar.edu.unq.desapp.grupoi.backenddesappapi.model.reviews;

import ar.edu.unq.desapp.grupoi.backenddesappapi.model.platform.Platform;
import ar.edu.unq.desapp.grupoi.backenddesappapi.model.user.Type_User;
import ar.edu.unq.desapp.grupoi.backenddesappapi.model.user.UserAbs;
import org.junit.jupiter.api.BeforeEach;

import java.util.Date;

public class ReviewTest {

    private PublicReview publicReview;
    private PremiumReview premiumReview;
    private UserAbs user;
    private UserAbs critic;



    @BeforeEach
    public void setUp() {
        this.user = new UserAbs(1L,
                "",
                Platform.NETFLIX.name(),
                Type_User.COMMON.name(),
                "Jose",
                "AR",
                null);
        this.critic = new UserAbs(12L,"", Platform.NETFLIX.name(),
                Type_User.CRITIC.name(), null, null,12);
        this.publicReview = new PublicReview("pdc1",
                "resume",
                "extended text",
                4, new Date(1990,11,6),
                "English", user, false);
        this.premiumReview = new PremiumReview("pdc2", "resume",
                "extended text pdc2", 3,
                new Date(1990,11,6),
                "English", critic);
    }
}
