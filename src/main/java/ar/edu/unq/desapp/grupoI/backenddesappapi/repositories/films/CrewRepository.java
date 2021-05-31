package ar.edu.unq.desapp.grupoi.backenddesappapi.repositories.films;

import ar.edu.unq.desapp.grupoi.backenddesappapi.model.films.Crew;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Configuration
@Repository
public interface CrewRepository extends JpaRepository<Crew, String> {
}
