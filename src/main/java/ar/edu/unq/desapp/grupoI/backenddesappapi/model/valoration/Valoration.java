package ar.edu.unq.desapp.grupoi.backenddesappapi.model.valoration;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "valoration")
public class Valoration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    @Column
    private Long review_id;

    @Column
    private String clike;

    @Transient
    private boolean like;

    @Column
    private long userId;

}
