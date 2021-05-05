package ar.edu.unq.desapp.grupoi.backenddesappapi.model.reviews;

import ar.edu.unq.desapp.grupoi.backenddesappapi.model.user.UserAbs;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;


@Entity
@Table(name = "premiumReview")
public class PremiumReview extends Review {

    @Column
    private Integer critic_id;


    public PremiumReview(
                         String tittle_tconst,
                         String resume,
                         String extendedText,
                         float rating,
                         LocalDate date,
                         String language,
                         UserAbs userAbs,
                         int critic_id) {
        super(
                tittle_tconst,
                resume,
                extendedText,
                rating,
                date,
                language,
                userAbs);
        this.critic_id = critic_id;
    }

    public PremiumReview() {

    }

    public int getCritic_id() {
        return critic_id;
    }
}
