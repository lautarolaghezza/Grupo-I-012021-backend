package ar.edu.unq.desapp.grupoi.backenddesappapi.model.reviews;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="subscribers")
public class TitleSubscribers {
    @Id
    String tconst;
    @ElementCollection
    List<String> users;

    public TitleSubscribers(List<String> users, String tconst) {
        this.users = users;
        this.tconst = tconst;
    }
}
