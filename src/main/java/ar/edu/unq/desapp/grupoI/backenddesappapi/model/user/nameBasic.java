package ar.edu.unq.desapp.grupoi.backenddesappapi.model.user;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Entity
@Table(name = "nameBasic")
public class nameBasic {
    @Id
    private String nconst;
    @Column
    private String primaryName;
    @Column
    private int birthYear;
    @Column
    private int deathYear;
    @Column
    private String knownForTitles;
    @Column
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

    public nameBasic() {

    }

    public String getNconst() {
        return nconst;
    }

    public String getPrimaryName() {
        return primaryName;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public int getDeathYear() {
        return deathYear;
    }

    public String getKnownForTitles() {
        return knownForTitles;
    }

    public String getPrimaryProfession() {
        return primaryProfession;
    }

    public List<String> getPrimaryProfessionList() {
        return primaryProfessionList;
    }

    public List<String> getKnownForTitlesList() {
        return knownForTitlesList;
    }
}
