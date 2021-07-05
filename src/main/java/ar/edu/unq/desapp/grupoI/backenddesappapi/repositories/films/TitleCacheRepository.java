package ar.edu.unq.desapp.grupoi.backenddesappapi.repositories.films;

import ar.edu.unq.desapp.grupoi.backenddesappapi.model.films.TitleCache;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Configuration
@Repository
public interface TitleCacheRepository extends CrudRepository<TitleCache, String> {
}
