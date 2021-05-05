package ar.edu.unq.desapp.grupoi.backenddesappapi.model.reviews;

import ar.edu.unq.desapp.grupoi.backenddesappapi.model.user.User;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;


@Entity
@Table(name = "premiumReview")
public class PremiumReview extends Review {

    @Column
    private Integer critic_id;


    public PremiumReview(Integer tittle_id,
                         String tittle_tconst,
                         String resume,
                         String extendedText,
                         float rating,
                         LocalDate date,
                         String language,
                         User user,
                         int critic_id) {
        super(
                tittle_tconst,
                resume,
                extendedText,
                rating,
                date,
                language,
                user);
        this.critic_id = critic_id;
    }

    public PremiumReview() {

    }

    public int getCritic_id() {
        return critic_id;
    }
}
