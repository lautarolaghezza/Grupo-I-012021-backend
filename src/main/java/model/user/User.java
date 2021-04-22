package model.user;

import lombok.Getter;
import lombok.Setter;
import model.Platform;
import model.reviews.Review;

import java.time.LocalDate;

@Getter
@Setter
public abstract class User {
    private Platform platform;
    private Type_User type_user;

    public User(Platform platform, Type_User type_user) {
        this.platform = platform;
        this.type_user = type_user;
    }

}
