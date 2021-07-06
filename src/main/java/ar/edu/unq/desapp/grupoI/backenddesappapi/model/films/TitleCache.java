package ar.edu.unq.desapp.grupoi.backenddesappapi.model.films;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import javax.persistence.Column;

@Getter
@Setter
@NoArgsConstructor
@RedisHash("title_cache")
public class TitleCache {

    @Id
    private String tconst;

    @Column
    private double rating;

    @Column
    private int votes;
}
