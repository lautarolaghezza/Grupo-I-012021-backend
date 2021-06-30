package ar.edu.unq.desapp.grupoi.backenddesappapi.model.reviews;

import ar.edu.unq.desapp.grupoi.backenddesappapi.model.user.UserAbs;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "review")
abstract public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long review_id;
    @Column
    private String tittle_tconst;
    @Column
    private String resume;
    @Column
    private String extendedText;
    @Column
    private float rating;
    @Column
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy/MM/dd")
    private Date date;
    @Column
    private String language;

    @ManyToOne()
    @JoinColumn(name = "user_id")
    private UserAbs userAbs;

    @Column
    private boolean spoiler_alert;




    public Review(Review reviewDTO) {
        this.date =  reviewDTO.date;
        this.extendedText = reviewDTO.extendedText;
        this.resume = reviewDTO.resume;
        this.language = reviewDTO.language;
        this.rating = reviewDTO.rating;
        this.userAbs = reviewDTO.userAbs;
    }
    public Review(String tittle_tconst,
                  String resume,
                  String extendedText,
                  float rating,
                  Date date,
                  String language, UserAbs userAbs, boolean spoiler_alert) {
        this.tittle_tconst = tittle_tconst;
        this.resume = resume;
        this.extendedText = extendedText;
        this.rating = rating;
        this.date = date;
        this.language = language;
        this.userAbs = userAbs;
    }

    public abstract boolean isPublicReview();
}
