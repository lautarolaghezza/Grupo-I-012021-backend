package ar.edu.unq.desapp.grupoi.backenddesappapi.model.films;

import ar.edu.unq.desapp.grupoi.backenddesappapi.dto.InverseSearchDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Table(name = "principals")
@Entity
public class Principals {

    @Id
    private String principaltconst;
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

    public Principals(InverseSearchDTO inverseSearchDTO) {
        this.principaltconst = inverseSearchDTO.getTconst();
        this.ordering = inverseSearchDTO.getOrdering();
        this.nconst = inverseSearchDTO.getNconst();
        this.category = inverseSearchDTO.getCategory();
        this.job = inverseSearchDTO.getJob();
        this.characters = inverseSearchDTO.getCharacters();
    }

    public boolean allAttrNull() {
        return (this.principaltconst == null && this.ordering == null && this.nconst == null && this.category == null &&
                this.job == null && this.characters == null);
    }
}
