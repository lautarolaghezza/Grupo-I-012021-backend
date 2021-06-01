package ar.edu.unq.desapp.grupoi.backenddesappapi.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class InverseSearchDTO {

    String tconst;
    Double rating;
    String titleType;
    String primaryTitle;
    String originalTitle;
    Boolean isAdult;
    Integer startYear;
    Integer endYear;
    Integer runtimeMinutes;
    String genres;
    String directors;
    String writers;
    Integer ordering;
    String nconst;
    String category;
    String job;
    String characters;

}
