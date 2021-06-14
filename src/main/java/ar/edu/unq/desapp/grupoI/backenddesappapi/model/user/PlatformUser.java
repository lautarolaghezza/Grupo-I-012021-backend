package ar.edu.unq.desapp.grupoi.backenddesappapi.model.user;

import ar.edu.unq.desapp.grupoi.backenddesappapi.model.platform.Platform;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Table(name = "platform_user")
@Entity
public class PlatformUser {

    @Id
    private String nickname;

    @Column
    private String password;

    @Column
    @Enumerated(EnumType.STRING)
    private Platform platform;

    @Column
    private String mail;


}
