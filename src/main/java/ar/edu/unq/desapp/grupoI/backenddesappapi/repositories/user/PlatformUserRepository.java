package ar.edu.unq.desapp.grupoi.backenddesappapi.repositories.user;

import ar.edu.unq.desapp.grupoi.backenddesappapi.model.user.PlatformUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PlatformUserRepository extends JpaRepository<PlatformUser, String> {

    @Query(value = "SELECT * FROM platform_user where platform_user.mail = :mail", nativeQuery = true)
    PlatformUser findByMail(@Param("mail") String mail);
}
