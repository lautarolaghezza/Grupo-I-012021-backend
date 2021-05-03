package model.user;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import model.platform.Platform;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Getter
@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class User {
    @Id
    private long userId;
    private Platform platform;
    private Type_User type_user;


    public User(long userId, Platform platform, Type_User type_user) {
        this.userId = userId;
        this.platform = platform;
        this.type_user = type_user;
    }
}
