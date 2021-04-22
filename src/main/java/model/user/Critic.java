package model.user;

import model.Platform;
import model.reviews.PremiumReview;
import model.reviews.Review;

import java.time.LocalDate;

public class Critic extends User {
    private int critic_id;

    public Critic(Platform platform, Type_User type_user, int critic_id) {
        super(platform, type_user);
        this.critic_id = critic_id;
    }

    public Review createReview(int tittle_id, String resume, String extendedText, float rating, LocalDate date,  String language) {
        return  new PremiumReview(tittle_id,resume,extendedText,rating,date,language,this,this.critic_id);
    }
}
