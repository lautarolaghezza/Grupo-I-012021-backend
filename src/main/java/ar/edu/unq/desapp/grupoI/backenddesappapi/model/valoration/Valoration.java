package ar.edu.unq.desapp.grupoi.backenddesappapi.model.valoration;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "valoration")
public class Valoration {

    public Valoration(Long id, Long review_id, String clike, boolean like, long userId) {
        this.id = id;
        this.review_id = review_id;
        this.clike = clike;
        this.like = like;
        this.userId = userId;
    }

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
