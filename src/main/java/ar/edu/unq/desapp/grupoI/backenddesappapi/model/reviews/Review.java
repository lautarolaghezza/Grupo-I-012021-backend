package ar.edu.unq.desapp.grupoi.backenddesappapi.model.reviews;

import ar.edu.unq.desapp.grupoi.backenddesappapi.model.user.UserAbs;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Table(name = "review")
abstract public class Review {
    @Id
    private String tittle_tconst;
    @Column
    private String resume;
    @Column
    private String extendedText;
    @Column
    private float rating;
    @Column
    private LocalDate date;
    @Column
    private String language;
    @Column
    private Long userId;

    public Review() {
    }

    @Transient
    private UserAbs userAbs;

    public String getTittle_tconst() {
        return tittle_tconst;
    }

    public String getResume() {
        return resume;
    }

    public String getExtendedText() {
        return extendedText;
    }

    public float getRating() {
        return rating;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getLanguage() {
        return language;
    }

    public Long getUserId() {
        return userId;
    }

    public UserAbs getUser() {
        return userAbs;
    }

    public Review(String tittle_tconst,
                  String resume,
                  String extendedText,
                  float rating,
                  LocalDate date,
                  String language, UserAbs userAbs) {
        this.tittle_tconst = tittle_tconst;
        this.resume = resume;
        this.extendedText = extendedText;
        this.rating = rating;
        this.date = date;
        this.language = language;
        this.userId = userAbs.getUserId();
        this.userAbs = userAbs;
    }


    public void setTittle_tconst(String tittle_tconst) {
        this.tittle_tconst = tittle_tconst;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public void setExtendedText(String extendedText) {
        this.extendedText = extendedText;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setUser(UserAbs userAbs) {
        this.userAbs = userAbs;
    }
}
