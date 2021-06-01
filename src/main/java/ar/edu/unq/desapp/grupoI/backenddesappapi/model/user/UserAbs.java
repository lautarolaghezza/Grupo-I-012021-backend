package ar.edu.unq.desapp.grupoi.backenddesappapi.model.user;

import ar.edu.unq.desapp.grupoi.backenddesappapi.model.platform.Platform;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user_table")
public class UserAbs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String password;

    @Column
    @Enumerated(EnumType.STRING)
    private Platform platform;

    @Column
    @Enumerated(EnumType.STRING)
    private Type_User type_user;

    @Column
    private String nickname;

    @Column
    private String location;

    @Column
    private Integer critic_id;


}
