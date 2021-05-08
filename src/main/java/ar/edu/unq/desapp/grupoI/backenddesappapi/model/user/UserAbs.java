package ar.edu.unq.desapp.grupoi.backenddesappapi.model.user;

import ar.edu.unq.desapp.grupoi.backenddesappapi.model.platform.Platform;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "userTable")
public abstract class UserAbs {
    @Id
    private long userId;

    @Column
    @Enumerated(EnumType.STRING)
    private Platform platform;

    @Column
    @Enumerated(EnumType.STRING)
    private Type_User type_user;

    public UserAbs(long userId, Platform platform, Type_User type_user) {
        this.userId = userId;
        this.platform = platform;
        this.type_user = type_user;
    }



    public UserAbs() {

    }

    public long getUserId() {
        return userId;
    }

    public Platform getPlatform() {
        return platform;
    }

    public Type_User getType_user() {
        return type_user;
    }

}
