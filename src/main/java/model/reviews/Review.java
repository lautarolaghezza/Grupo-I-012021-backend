package model.reviews;

import model.Plataform;

import java.time.LocalDate;

abstract public class Review {
    private String resume;
    private String extendedText;
    private float rating;
    private LocalDate date;
    private Plataform plataform;
    private String language;

    public Review(String resume,
                  String extendedText,
                  float rating,
                  LocalDate date,
                  Plataform plataform,
                  String language) {
        this.resume = resume;
        this.extendedText = extendedText;
        this.rating = rating;
        this.date = date;
        this.plataform = plataform;
        this.language = language;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public String getExtendedText() {
        return extendedText;
    }

    public void setExtendedText(String extendedText) {
        this.extendedText = extendedText;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Plataform getPlataform() {
        return plataform;
    }

    public void setPlataform(Plataform plataform) {
        this.plataform = plataform;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}
