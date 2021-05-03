package model.user;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import model.platform.Platform;
import model.reviews.PublicReview;


import javax.persistence.Entity;
import java.time.LocalDate;

@Getter
@NoArgsConstructor
@Entity
public class CommonUser extends User {

    private String nick;
    private String location;


    public CommonUser(long userId, Platform platform, Type_User type_user, String nick, String location) {
        super(userId, platform, type_user);
        this.nick = nick;
        this.location = location;
    }

    public PublicReview createReview(int tittle_id,
                                     String tittle_tconst,
                                     String resume,
                                     String extendedText, float rating,
                                     LocalDate date,
                                     String language, boolean spoiler_Alert) {
        PublicReview review = new PublicReview(tittle_id,
                tittle_tconst,
                resume,
                extendedText,
                rating,
                date,
                language,
                this,
                spoiler_Alert);

        return  review;
    }
}
