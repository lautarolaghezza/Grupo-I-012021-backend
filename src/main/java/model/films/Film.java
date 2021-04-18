package model.films;

import java.util.List;

abstract public class Film {
    private String tittleType;
    private String primaryTittle;
    private String originalTittle;
    private boolean isAdult;
    private int startYear;
    private int runtimeMinutes;
    private List<String> genres;


    public Film(String tittleType, String primaryTittle, String originalTittle,
                boolean isAdult, int startYear, int runtimeMinutes, List<String> genres) {
        this.tittleType = tittleType;
        this.primaryTittle = primaryTittle;
        this.originalTittle = originalTittle;
        this.isAdult = isAdult;
        this.startYear = startYear;
        this.runtimeMinutes = runtimeMinutes;
        this.genres = genres;
    }
}
