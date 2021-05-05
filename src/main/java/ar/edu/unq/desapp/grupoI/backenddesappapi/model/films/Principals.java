package ar.edu.unq.desapp.grupoi.backenddesappapi.model.films;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Table(name ="principals")
@Entity
public class Principals {
    @Id
    private String tconst;
    @Column
    private Integer ordering;
    @Column
    private String nconst;
    @Column
    private String category;
    @Column
    private String job;
    @Column
    private String characters;

    public String getTconst() {
        return tconst;
    }

    public Integer getOrdering() {
        return ordering;
    }

    public String getNconst() {
        return nconst;
    }

    public String getCategory() {
        return category;
    }

    public String getJob() {
        return job;
    }

    public String getCharacters() {
        return characters;
    }
}
