package model.films;

import java.util.List;
import java.util.Set;

abstract public class Film {
    private String tittleType;
    private String primaryTittle;
    private String originalTittle;
    private boolean isAdult;
    private int startYear;
    private  int runtimeMinutes;
    private List<String> genres;


    public String getTittleType() {
        return tittleType;
    }

    public void setTittleType(String tittleType) {
        this.tittleType = tittleType;
    }

    public String getPrimaryTittle() {
        return primaryTittle;
    }

    public void setPrimaryTittle(String primaryTittle) {
        this.primaryTittle = primaryTittle;
    }

    public String getOriginalTittle() {
        return originalTittle;
    }

    public void setOriginalTittle(String originalTittle) {
        this.originalTittle = originalTittle;
    }

    public boolean isAdult() {
        return isAdult;
    }

    public void setAdult(boolean adult) {
        isAdult = adult;
    }

    public int getStartYear() {
        return startYear;
    }

    public void setStartYear(int startYear) {
        this.startYear = startYear;
    }

    public int getRuntimeMinutes() {
        return runtimeMinutes;
    }

    public void setRuntimeMinutes(int runtimeMinutes) {
        this.runtimeMinutes = runtimeMinutes;
    }
    public List<String> getGenres() {
        return genres;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }
}
