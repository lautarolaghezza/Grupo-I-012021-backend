package model.reviews;

import com.sun.org.apache.bcel.internal.generic.DREM;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import model.Platform;
import model.user.User;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
abstract public class Review {
    private Integer tittle_id;
    private String resume;
    private String extendedText;
    private float rating;
    private LocalDate date;
    private String language;
    private User user;

    public Review(Integer tittle_id,
                  String resume,
                  String extendedText,
                  float rating,
                  LocalDate date,
                  String language, User user) {
        this.tittle_id = tittle_id;
        this.resume = resume;
        this.extendedText = extendedText;
        this.rating = rating;
        this.date = date;
        this.language = language;
        this.user = user;

    }
}
