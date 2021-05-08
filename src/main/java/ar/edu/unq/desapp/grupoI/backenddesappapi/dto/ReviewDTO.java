package ar.edu.unq.desapp.grupoi.backenddesappapi.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
public class ReviewDTO {
    public String tittle_tconst;
    public String resume;
    public String extendedText;
    public float rating;
    public Date date;
    public String language;
    public Long userId;
    public boolean spoiler_Alert;
    public Integer critic_id;
}
