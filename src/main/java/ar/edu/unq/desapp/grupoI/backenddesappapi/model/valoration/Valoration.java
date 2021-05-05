package ar.edu.unq.desapp.grupoi.backenddesappapi.model.valoration;

import org.hibernate.annotations.Type;

import javax.persistence.*;

@Entity
@Table(name = "valoration")
public class Valoration {
    @Id
    private String tconst;

    @Transient
    private boolean like;

    @Column
    private Integer clike;

    @Column
    private long userId;

    public Valoration(String tconst, boolean like, long userId) {
        this.tconst = tconst;
        this.like = like;
        this.userId = userId;
        this.clike = like ? 1 : 0;
    }

    public Valoration() {

    }

    public String getTconst() {
        return tconst;
    }

    public boolean isLike() {
        return like;
    }

    public long getUserId() {
        return userId;
    }
}
