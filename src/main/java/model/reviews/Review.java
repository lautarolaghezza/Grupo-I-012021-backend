package model.reviews;

import lombok.Getter;
import lombok.Setter;
import model.Platform;

import java.time.LocalDate;

@Getter
@Setter
abstract public class Review {
    private String resume;
    private String extendedText;
    private float rating;
    private LocalDate date;
    private Platform platform;
    private String language;

    public Review(String resume,
                  String extendedText,
                  float rating,
                  LocalDate date,
                  Platform platform,
                  String language) {
        this.resume = resume;
        this.extendedText = extendedText;
        this.rating = rating;
        this.date = date;
        this.platform = platform;
        this.language = language;
    }

    public Review() {

    }
}
