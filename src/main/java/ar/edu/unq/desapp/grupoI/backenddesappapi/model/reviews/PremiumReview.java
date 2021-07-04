package ar.edu.unq.desapp.grupoi.backenddesappapi.model.reviews;

import ar.edu.unq.desapp.grupoi.backenddesappapi.model.user.UserAbs;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;


@Entity
@Getter
@Setter
@AllArgsConstructor
@Table(name = "premiumReview")
public class PremiumReview extends Review {

    public PremiumReview(String tittle_tconst, String resume,
                         String extendedText, Double rating,
                         Date date, String language,
                         UserAbs userAbs) {
        super(tittle_tconst, resume,
                extendedText, rating,
                date, language,
                userAbs, false);
    }


    @Override
    public boolean isPublicReview() {
        return false;
    }
}
