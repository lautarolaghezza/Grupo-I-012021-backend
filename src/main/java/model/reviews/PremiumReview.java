package model.reviews;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import model.user.User;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class PremiumReview extends Review {

    @Id
    private int critic_id;


    public PremiumReview(Integer tittle_id,
                         String tittle_tconst,
                         String resume,
                         String extendedText,
                         float rating,
                         LocalDate date,
                         String language,
                         User user,
                         int critic_id) {
        super(tittle_id,
                tittle_tconst,
                resume,
                extendedText,
                rating,
                date,
                language,
                user);
        this.critic_id = critic_id;
    }
}
