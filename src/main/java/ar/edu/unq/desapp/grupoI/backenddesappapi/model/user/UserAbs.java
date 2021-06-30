package ar.edu.unq.desapp.grupoi.backenddesappapi.model.user;

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

public class UserAbs  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_id;

    @Column
    private String password;

    @Column
    private String platform;

    @Column
    private String type_user;

    @Column
    private String nickname;

    @Column
    private String location;

    @Column
    private Integer critic_id;

}
