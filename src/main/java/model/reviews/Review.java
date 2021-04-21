package model.reviews;

import lombok.Getter;
import lombok.Setter;
import model.Platform;
import model.user.User;

import java.time.LocalDate;

@Getter
@Setter
abstract public class Review {
    private int tittle_id;
    private String resume;
    private String extendedText;
    private float rating;
    private LocalDate date;
    private Platform platform;
    private String language;
    private User user;

    public Review(int tittle_id,
                  String resume,
                  String extendedText,
                  float rating,
                  LocalDate date,
                  Platform platform,
                  String language, User user) {
        this.tittle_id = tittle_id;
        this.resume = resume;
        this.extendedText = extendedText;
        this.rating = rating;
        this.date = date;
        this.platform = platform;
        this.language = language;
        this.user = user;
    }

    public  Review(){

    }

}
