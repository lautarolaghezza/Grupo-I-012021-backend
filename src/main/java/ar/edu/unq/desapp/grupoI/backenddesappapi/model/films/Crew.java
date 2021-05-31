package ar.edu.unq.desapp.grupoi.backenddesappapi.model.films;


import ar.edu.unq.desapp.grupoi.backenddesappapi.dto.InverseSearchDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "crew")
public class Crew {
    @Id
    private String tconst;
    @Column
    private String directors;
    @Column
    private String writers;

    public Crew(InverseSearchDTO inverseSearchDTO) {
        this.tconst = inverseSearchDTO.getTconst();
        this.directors = inverseSearchDTO.getDirectors();
        this.writers = inverseSearchDTO.getWriters();
    }

}
