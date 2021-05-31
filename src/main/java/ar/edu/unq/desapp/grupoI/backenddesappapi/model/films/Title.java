package ar.edu.unq.desapp.grupoi.backenddesappapi.model.films;

import ar.edu.unq.desapp.grupoi.backenddesappapi.model.reviews.PremiumReview;
import ar.edu.unq.desapp.grupoi.backenddesappapi.model.reviews.PublicReview;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Table(name = "tittle")
@Entity
public class Title extends Classifiable {

    @Column
    private String titleType;
    @Column
    private String primaryTitle;
    @Column
    private String originalTitle;
    @Column
    private Boolean isAdult;
    @Column
    private Integer startYear;
    @Column
    private Integer endYear;
    @Column
    private Integer runtimeMinutes;
    @Column
    private String genres;



    public Title(String tconst, String titleType, String primaryTitle,
                 String originalTitle, Boolean isAdult,
                 Integer startYear, Integer endYear, Integer runtimeMinutes,
                 String genres, List<PremiumReview> critics,
                 List<PublicReview> reviews) {
        super(tconst, critics, reviews);
        this.titleType = titleType;
        this.primaryTitle = primaryTitle;
        this.originalTitle = originalTitle;
        this.isAdult = isAdult;
        this.startYear = startYear;
        this.endYear = endYear;
        this.runtimeMinutes = runtimeMinutes;
        this.genres = genres;
    }
}
