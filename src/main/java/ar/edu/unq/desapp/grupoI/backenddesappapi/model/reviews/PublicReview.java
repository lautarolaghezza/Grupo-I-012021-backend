package ar.edu.unq.desapp.grupoi.backenddesappapi.model.reviews;

import ar.edu.unq.desapp.grupoi.backenddesappapi.model.user.UserAbs;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;


@Entity
@Table(name = "publicReview")
public class PublicReview extends Review {
    @Column
    private boolean spoiler_Alert;

    public PublicReview(String tittle_tconst,
                        String resume, String extendedText,
                        float rating, LocalDate date,
                        String language, UserAbs userAbs,
                        boolean spoiler_Alert) {
        super( tittle_tconst,
                resume, extendedText,
                rating, date,
                language, userAbs);
        this.spoiler_Alert = spoiler_Alert;
    }

    public PublicReview() {
    }

    public boolean isSpoiler_Alert() {
        return spoiler_Alert;
    }
}
