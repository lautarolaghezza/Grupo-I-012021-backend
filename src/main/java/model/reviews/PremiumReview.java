package model.reviews;

import lombok.Getter;
import lombok.Setter;
import model.Platform;

import java.time.LocalDate;

@Getter
@Setter
public class PremiumReview extends Review {
    private int critic_id;

    public PremiumReview(String resume, String extendedText, int rating, LocalDate date,
                         Platform platform, String language, int critic_id) {
        super(resume, extendedText, rating, date, platform, language);
        this.critic_id = critic_id;
    }

    public PremiumReview() {
        super();
    }
}
