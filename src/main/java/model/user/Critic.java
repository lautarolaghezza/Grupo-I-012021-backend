package model.user;

import lombok.Getter;
import model.platform.Platform;
import model.reviews.PremiumReview;
import model.reviews.Review;

import java.time.LocalDate;

@Getter
public class Critic extends User {
    private int critic_id;

    public Critic(long userId, Platform platform, Type_User type_user, int critic_id) {
        super(userId, platform, type_user);
        this.critic_id = critic_id;
    }

    public Review createReview(int tittle_id,
                               String tittle_tconst,
                               String resume,
                               String extendedText,
                               float rating,
                               LocalDate date,
                               String language) {
        return  new PremiumReview(tittle_id,
                tittle_tconst,
                resume,
                extendedText,
                rating,
                date,
                language,
                this,
                this.critic_id);
    }
}
