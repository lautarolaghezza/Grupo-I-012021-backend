package model.reviews;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import model.Platform;
import model.user.User;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class PremiumReview extends Review {
    private int critic_id;


    public PremiumReview(int tittle_id,
                         String resume,
                         String extendedText,
                         float rating,
                         LocalDate date,
                         String language,
                         User user,
                         int critic_id) {
        super(tittle_id,
                resume,
                extendedText,
                rating,
                date,
                language,
                user);
        this.critic_id = critic_id;
    }

}
