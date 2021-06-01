package ar.edu.unq.desapp.grupoi.backenddesappapi.model.reviews;

import ar.edu.unq.desapp.grupoi.backenddesappapi.model.user.UserAbs;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "publicReview")
public class PublicReview extends Review {
    @Column
    private boolean spoiler_Alert;

    public PublicReview(String tittle_tconst,
                        String resume, String extendedText,
                        float rating, Date date,
                        String language, UserAbs userAbs,
                        boolean spoiler_Alert) {
        super( tittle_tconst,
                resume, extendedText,
                rating, date,
                language, userAbs);
        this.spoiler_Alert = spoiler_Alert;
    }


    public PublicReview(PublicReview reviewDTO) {
        super(reviewDTO);
    }

    @Override
    public boolean isPublicReview() {
        return true;
    }
}
