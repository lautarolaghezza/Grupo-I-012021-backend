package ar.edu.unq.desapp.grupoi.backenddesappapi.model.user;

import ar.edu.unq.desapp.grupoi.backenddesappapi.model.platform.Platform;

import javax.persistence.*;

@Entity
@Table(name = "user")
public abstract class User {
    @Id
    private long userId;

    //@Column
    @Enumerated(EnumType.STRING)
    private Platform platform;

    //@Column
    @Enumerated(EnumType.STRING)
    private Type_User type_user;


    public User(long userId, Platform platform, Type_User type_user) {
        this.userId = userId;
        this.platform = platform;
        this.type_user = type_user;
    }



    public User() {

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
