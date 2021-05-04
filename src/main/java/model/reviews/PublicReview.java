package model.reviews;

import lombok.Getter;
import lombok.NoArgsConstructor;
import model.user.User;

import javax.persistence.Entity;
import java.time.LocalDate;

@Getter
@Entity
@NoArgsConstructor
public class PublicReview extends Review {
    private boolean spoiler_Alert;

    public PublicReview(String tittle_tconst, String resume, String extendedText, float rating, LocalDate date, String language, User user, boolean spoiler_Alert) {
        super(tittle_tconst, resume, extendedText, rating, date, language, user);
        this.spoiler_Alert = spoiler_Alert;
    }

}
