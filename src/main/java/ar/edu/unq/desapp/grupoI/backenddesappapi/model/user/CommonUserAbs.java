package ar.edu.unq.desapp.grupoi.backenddesappapi.model.user;

import ar.edu.unq.desapp.grupoi.backenddesappapi.model.platform.Platform;
import ar.edu.unq.desapp.grupoi.backenddesappapi.model.reviews.PublicReview;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;


@Entity
//@Table(name = "commonUser")
public class CommonUserAbs extends UserAbs {
    @Column
    private String nick;
    @Column
    private String location;


    public CommonUserAbs(long userId, Platform platform, Type_User type_user, String nick, String location) {
        super(userId, platform, type_user);
        this.nick = nick;
        this.location = location;
    }

    public CommonUserAbs() {

    }

    public PublicReview createReview(String tittle_tconst,
                                     String resume,
                                     String extendedText, float rating,
                                     Date date,
                                     String language, boolean spoiler_Alert) {
        PublicReview review = new PublicReview(
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

    public String getNick() {
        return nick;
    }

    public String getLocation() {
        return location;
    }
}
