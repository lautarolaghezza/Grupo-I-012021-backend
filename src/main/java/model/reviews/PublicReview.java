package model.reviews;

import lombok.Getter;
import lombok.Setter;
import model.Platform;
import model.user.CommonUser;
import model.user.User;

import java.time.LocalDate;

@Getter
@Setter
public class PublicReview extends Review {
    private boolean spoiler_Alert;

    public PublicReview(int tittle_id, String resume,
                        String extendedText, float rating,
                        LocalDate date, Platform platform,
                        String language, User user, boolean spoiler_Alert) {
        super(tittle_id, resume, extendedText, rating, date, platform, language, user);
        this.spoiler_Alert = spoiler_Alert;
    }

    public PublicReview() {
        super();
    }

}
