package ar.edu.unq.desapp.grupoi.backenddesappapi.model.films;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "crew")
public class Crew {
    @Id
    private String tconst;
    @Column
    private String directors;
    @Column
    private String writers;

    public String getTconst() {
        return tconst;
    }

    public String getDirectors() {
        return directors;
    }

    public String getWriters() {
        return writers;
    }

}
