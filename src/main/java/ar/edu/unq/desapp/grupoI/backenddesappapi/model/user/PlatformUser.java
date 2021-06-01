package ar.edu.unq.desapp.grupoi.backenddesappapi.model.user;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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


}
