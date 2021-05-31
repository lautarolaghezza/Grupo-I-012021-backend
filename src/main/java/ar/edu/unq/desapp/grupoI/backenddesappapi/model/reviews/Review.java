package ar.edu.unq.desapp.grupoi.backenddesappapi.model.reviews;

import ar.edu.unq.desapp.grupoi.backenddesappapi.model.rating.Rating;
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
    private Long id;
    @Column
    private String tittle_tconst;
    @Column
    private String resume;
    @Column
    private String extendedText;
    @Column
    private float ratingId;
    @Column
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy/MM/dd")
    private Date date;
    @Column
    private String language;
    @Column
    private Long userId;


    @Transient
    private UserAbs userAbs;

    public Review(Review reviewDTO) {
        this.date =  reviewDTO.date;
        this.extendedText = reviewDTO.extendedText;
        this.resume = reviewDTO.resume;
        this.language = reviewDTO.language;
        this.ratingId = reviewDTO.ratingId;
        this.userId = reviewDTO.userId;
        this.userAbs = reviewDTO.userAbs;
    }
    public Review(String tittle_tconst,
                  String resume,
                  String extendedText,
                  float rating,
                  Date date,
                  String language, UserAbs userAbs) {
        this.tittle_tconst = tittle_tconst;
        this.resume = resume;
        this.extendedText = extendedText;
        this.ratingId = ratingId;
        this.date = date;
        this.language = language;
        this.userId = userAbs.getId();
        this.userAbs = userAbs;
    }

}
