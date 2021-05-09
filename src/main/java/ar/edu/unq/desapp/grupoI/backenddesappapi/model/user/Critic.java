package ar.edu.unq.desapp.grupoi.backenddesappapi.model.user;

import ar.edu.unq.desapp.grupoi.backenddesappapi.model.platform.Platform;
import ar.edu.unq.desapp.grupoi.backenddesappapi.model.reviews.PremiumReview;
import ar.edu.unq.desapp.grupoi.backenddesappapi.model.reviews.Review;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;


@Entity
@Table(name = "critic")
public class Critic extends UserAbs {
    @Column
    private Integer critic_id;

    public Critic(long userId, Platform platform, Type_User type_user, int critic_id) {
        super(userId, platform, type_user);
        this.critic_id = critic_id;
    }

    public Critic() {

    }

    public Review createReview(
                               String tittle_tconst,
                               String resume,
                               String extendedText,
                               float rating,
                               Date date,
                               String language) {
        return  new PremiumReview(
                tittle_tconst,
                resume,
                extendedText,
                rating,
                date,
                language,
                this,
                this.critic_id);
    }

    public int getCritic_id() {
        return critic_id;
    }
}
