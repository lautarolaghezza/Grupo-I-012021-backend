package dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class ReviewDTO {
    public String tittle_tconst;
    public String resume;
    public String extendedText;
    public float rating;
    public LocalDate date;
    public String language;
    public Long userId;
    public boolean spoiler_Alert;
}
