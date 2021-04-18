package model.reviews;

import model.Plataform;

import java.time.LocalDate;

public class PremiumReview extends  Review{
    private int critic_id;

    public PremiumReview(String resume, String extendedText, int rating, LocalDate date, Plataform plataform, String language, int critic_id) {
        super(resume,
                extendedText,
                rating,
                date,
                plataform,
                language);
        this.critic_id = critic_id;
    }
}
