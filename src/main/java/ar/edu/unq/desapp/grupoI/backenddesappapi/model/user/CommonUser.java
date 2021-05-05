package ar.edu.unq.desapp.grupoi.backenddesappapi.model.user;

import ar.edu.unq.desapp.grupoi.backenddesappapi.model.platform.Platform;
import ar.edu.unq.desapp.grupoi.backenddesappapi.model.reviews.PublicReview;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;


@Entity
@Table(name = "commonUser")
public class CommonUser extends User {
    @Column
    private String nick;
    @Column
    private String location;


    public CommonUser(long userId, Platform platform, Type_User type_user, String nick, String location) {
        super(userId, platform, type_user);
        this.nick = nick;
        this.location = location;
    }

    public CommonUser() {

    }

    public PublicReview createReview(String tittle_tconst,
                                     String resume,
                                     String extendedText, float rating,
                                     LocalDate date,
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
