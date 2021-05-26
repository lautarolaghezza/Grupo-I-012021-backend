package ar.edu.unq.desapp.grupoi.backenddesappapi.model.reviews;

import ar.edu.unq.desapp.grupoi.backenddesappapi.model.user.UserAbs;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "premiumReview")
public class PremiumReview extends Review {

    @Column
    private Integer critic_id;

    public PremiumReview(String tittle_tconst, String resume,
                         String extendedText, float rating,
                         Date date, String language,
                         UserAbs userAbs, Integer critic_id) {
        super(tittle_tconst, resume,
                extendedText, rating,
                date, language,
                userAbs);
        this.critic_id = critic_id;
    }

    public PremiumReview(
                         String tittle_tconst,
                         String resume,
                         String extendedText,
                         float rating,
                         Date date,
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

}
