package ar.edu.unq.desapp.grupoi.backenddesappapi.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ReviewOrderDTO {

    boolean ratingAsc;
    boolean ratingDesc;
    boolean dateAsc;
    boolean dateDesc;
}
