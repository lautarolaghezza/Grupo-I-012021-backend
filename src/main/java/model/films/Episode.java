package model.films;

import java.util.List;

public class Episode extends Film {
    public Episode(String tittleType, String primaryTittle, String originalTittle, boolean isAdult, int startYear, int runtimeMinutes, List<String> genres) {
        super(tittleType, primaryTittle, originalTittle, isAdult, startYear, runtimeMinutes, genres);
    }
}
