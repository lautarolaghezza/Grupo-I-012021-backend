package ar.edu.unq.desapp.grupoi.backenddesappapi.repositories.review;

import ar.edu.unq.desapp.grupoi.backenddesappapi.model.reviews.TitleSubscribers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubscribeRepository extends JpaRepository<TitleSubscribers, String> {
}
