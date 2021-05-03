package model.user;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
public class nameBasic {
    @Id
    private String nconst;
    private String primaryName;
    private int birthYear;
    private int deathYear;
    private String knownForTitles;
    private String primaryProfession;

    @Transient
    private List<String> primaryProfessionList;
    @Transient
    private List<String> knownForTitlesList;

    public nameBasic(String nconst,
                     String primaryName,
                     int birthYear,
                     int deathYear,
                     String knownForTitles,
                     String primaryProfession) {
        this.nconst = nconst;
        this.primaryName = primaryName;
        this.birthYear = birthYear;
        this.deathYear = deathYear;
        this.knownForTitles = knownForTitles;
        this.primaryProfession = primaryProfession;
        this.knownForTitlesList = new ArrayList<String>(Arrays.asList(knownForTitles.split(",")));
        this.primaryProfessionList = new ArrayList<String>(Arrays.asList(primaryProfession.split(",")));
    }
}
