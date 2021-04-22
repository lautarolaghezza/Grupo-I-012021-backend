package model.reviews;

import lombok.Getter;
import lombok.Setter;
import model.Platform;

import java.time.LocalDate;

@Getter
@Setter
public class PublicReview extends Review {
    private String nick;
    private int user_id;
    private String location;

    public PublicReview(String resume, String extendedText, int rating, LocalDate date, Platform platform,
                        String language, String nick, int user_id, String location) {
        super(resume, extendedText, rating, date, platform, language);
        this.nick = nick;
        this.user_id = user_id;
        this.location = location;
    }

    public PublicReview() {
        super();
    }


}
