package ar.edu.unq.desapp.grupoi.backenddesappapi.model.user;

import ar.edu.unq.desapp.grupoi.backenddesappapi.model.platform.Platform;
import ar.edu.unq.desapp.grupoi.backenddesappapi.model.reviews.PremiumReview;
import ar.edu.unq.desapp.grupoi.backenddesappapi.model.reviews.Review;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;


@Entity
@Table(name = "critic")
public class Critic extends User {
    @Column
    private Integer critic_id;

    public Critic(long userId, Platform platform, Type_User type_user, int critic_id) {
        super(userId, platform, type_user);
        this.critic_id = critic_id;
    }

    public Critic() {

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

    public int getCritic_id() {
        return critic_id;
    }
}
