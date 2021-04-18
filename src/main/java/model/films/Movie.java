package model.films;

import java.util.List;

public class Movie extends Film {
    public Movie(String tittleType, String primaryTittle, String originalTittle, boolean isAdult, int startYear, int runtimeMinutes, List<String> genres) {
        super(tittleType, primaryTittle, originalTittle, isAdult, startYear, runtimeMinutes, genres);
    }
}
