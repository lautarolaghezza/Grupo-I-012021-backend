package ar.edu.unq.desapp.grupoi.backenddesappapi.model.films;

import ar.edu.unq.desapp.grupoi.backenddesappapi.model.reviews.PremiumReview;
import ar.edu.unq.desapp.grupoi.backenddesappapi.model.reviews.PublicReview;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tittle")
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

    public Title() {

    }


    public String getTitleType() {
        return titleType;
    }

    public String getPrimaryTitle() {
        return primaryTitle;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public Boolean getAdult() {
        return isAdult;
    }

    public Integer getStartYear() {
        return startYear;
    }

    public Integer getEndYear() {
        return endYear;
    }

    public Integer getRuntimeMinutes() {
        return runtimeMinutes;
    }

    public String getGenres() {
        return genres;
    }

    public void setTitleType(String titleType) {
        this.titleType = titleType;
    }

    public void setPrimaryTitle(String primaryTitle) {
        this.primaryTitle = primaryTitle;
    }

    public void setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
    }

    public void setAdult(Boolean adult) {
        isAdult = adult;
    }

    public void setStartYear(Integer startYear) {
        this.startYear = startYear;
    }

    public void setEndYear(Integer endYear) {
        this.endYear = endYear;
    }

    public void setRuntimeMinutes(Integer runtimeMinutes) {
        this.runtimeMinutes = runtimeMinutes;
    }

    public void setGenres(String genres) {
        this.genres = genres;
    }
}
