package model.reviews;

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
    private int tittle_id;
    private String resume;
    private String extendedText;
    private float rating;
    private LocalDate date;
    private String language;
    private User user;

    public Review(int tittle_id,
                  String resume,
                  String extendedText,
                  float rating,
                  LocalDate date,
                  String language, User user) {
        this.tittle_id = tittle_id;

    }
}
