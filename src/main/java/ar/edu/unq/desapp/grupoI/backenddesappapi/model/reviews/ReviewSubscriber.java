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
public class ReviewSubscriber {
    @Id
    Integer reviewId;
    @ElementCollection
    List<String> users;

    public ReviewSubscriber(List<String> users, Integer reviewId) {
        this.users = users;
        this.reviewId = reviewId;
    }
}
