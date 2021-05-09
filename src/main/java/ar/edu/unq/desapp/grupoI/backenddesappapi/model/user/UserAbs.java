package ar.edu.unq.desapp.grupoi.backenddesappapi.model.user;

import ar.edu.unq.desapp.grupoi.backenddesappapi.model.platform.Platform;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "user_table")
public abstract class UserAbs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @Enumerated(EnumType.STRING)
    private Platform platform;

    @Column
    @Enumerated(EnumType.STRING)
    private Type_User type_user;

    public UserAbs(long userId, Platform platform, Type_User type_user) {
        this.id = userId;
        this.platform = platform;
        this.type_user = type_user;
    }



    public UserAbs() {

    }

    public long getId() {
        return id;
    }

    public Platform getPlatform() {
        return platform;
    }

    public Type_User getType_user() {
        return type_user;
    }

}
