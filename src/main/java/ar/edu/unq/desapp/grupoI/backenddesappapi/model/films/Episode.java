package ar.edu.unq.desapp.grupoi.backenddesappapi.model.films;
import ar.edu.unq.desapp.grupoi.backenddesappapi.model.reviews.PremiumReview;
import ar.edu.unq.desapp.grupoi.backenddesappapi.model.reviews.PublicReview;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "epispde")
public class Episode extends Classifiable {

    @Column
    private String parentTconst;
    @Column
    private Integer seasonNumber;
    @Column
    private Integer episodeNumber;

    public Episode(String tconst, String parentTconst, Integer seasonNumber, Integer episodeNumber,
                   List<PremiumReview> critics, List<PublicReview> reviews) {
        super(tconst);
        this.parentTconst = parentTconst;
        this.seasonNumber = seasonNumber;
        this.episodeNumber = episodeNumber;
    }

    public Episode() {

    }

    public String getParentTconst() {
        return parentTconst;
    }

    public Integer getSeasonNumber() {
        return seasonNumber;
    }

    public Integer getEpisodeNumber() {
        return episodeNumber;
    }
}
