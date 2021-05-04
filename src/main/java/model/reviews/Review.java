package model.reviews;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import model.user.User;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Review {
    @Id
    private Long review_id;
    private String tittle_tconst;
    private String resume;
    private String extendedText;
    private float rating;
    private LocalDate date;
    private String language;
    private Long userId;

    @Transient
    private User user;


    public Review(String tittle_tconst,
                  String resume,
                  String extendedText,
                  float rating,
                  LocalDate date,
                  String language, User user) {
        this.tittle_tconst = tittle_tconst;
        this.resume = resume;
        this.extendedText = extendedText;
        this.rating = rating;
        this.date = date;
        this.language = language;
        this.userId = user.getUserId();
        this.user = user;
    }
}
