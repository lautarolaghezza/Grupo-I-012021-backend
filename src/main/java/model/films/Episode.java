package model.films;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import model.reviews.PremiumReview;
import model.reviews.PublicReview;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class Episode extends Classifiable {

    private String tconst;
    private String parentTconst;
    private Integer seasonNumber;
    private Integer episodeNumber;

    public Episode(String tconst, String parentTconst, Integer seasonNumber, Integer episodeNumber,
                   List<PremiumReview> critics, List<PublicReview> reviews) {
        super(critics, reviews);
        this.tconst = tconst;
        this.parentTconst = parentTconst;
        this.seasonNumber = seasonNumber;
        this.episodeNumber = episodeNumber;
    }
}
