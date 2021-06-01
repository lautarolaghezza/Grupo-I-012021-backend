package ar.edu.unq.desapp.grupoi.backenddesappapi.repositories.films;

import ar.edu.unq.desapp.grupoi.backenddesappapi.model.films.Principals;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Configuration
@Repository
public interface PrincipalsRepository extends JpaRepository<Principals, String> {
}
