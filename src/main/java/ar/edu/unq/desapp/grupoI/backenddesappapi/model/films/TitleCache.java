package ar.edu.unq.desapp.grupoi.backenddesappapi.model.films;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.redis.core.RedisHash;

import javax.persistence.Column;
import javax.persistence.Id;

@Getter
@Setter
@NoArgsConstructor
@RedisHash("TitleCache")
public class TitleCache {

    @Id
    private String tconst;

    @Column
    private double rating;

    @Column
    private int votes;
}
