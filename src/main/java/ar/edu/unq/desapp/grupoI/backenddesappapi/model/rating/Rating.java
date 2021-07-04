package ar.edu.unq.desapp.grupoi.backenddesappapi.model.rating;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "rating")
public class Rating {

    @Id
    private String ratingtconst;

    @Column
    private Double average_rating;

    @Column
    private int num_votes;
    
}
