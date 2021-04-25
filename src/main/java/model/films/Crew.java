package model.films;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class Crew {
    private String tconst;
    private List<String> directors;
    private List<String> writers;
}
