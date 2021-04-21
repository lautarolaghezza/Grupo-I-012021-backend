package model.user;

import lombok.Getter;
import lombok.Setter;
import model.Platform;
import model.reviews.PremiumReview;
import model.reviews.PublicReview;
import model.reviews.Review;

import java.time.LocalDate;

@Getter
@Setter
public class CommonUser extends User {
    private String nick;
    private String location;
    private int user_id;

    public CommonUser(Platform platform,
                      Type_User type_user,
                      String nick,
                      String location,
                      int user_id) {
        super(platform, type_user);
        this.nick = nick;
        this.location = location;
        this.user_id = user_id;
    }


    public PublicReview createReview(int tittle_id, String resume,
                               String extendedText, float rating,
                               LocalDate date, Platform platform,
                               String language, boolean spoiler_Alert) {
        return  new PublicReview(tittle_id, resume,
                extendedText, rating,
                date, platform, language,
                this,spoiler_Alert);
    }
}
