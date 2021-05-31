package ar.edu.unq.desapp.grupoi.backenddesappapi.repositories.user;

import ar.edu.unq.desapp.grupoi.backenddesappapi.model.user.UserAbs;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Configuration
@Repository
public interface UserRepository extends JpaRepository<UserAbs, Integer> {


    @Query(value = "SELECT * FROM user_table where user_table.id = :id", nativeQuery = true)
    UserAbs findBy(@Param("id") long id);

    @Query(value ="SELECT * FROM user_table u WHERE u.location = :location", nativeQuery = true)
    List<UserAbs> findUserByLocation(@Param("location")String location);

    @Query(value ="SELECT * FROM user_table u WHERE u.platform = :platform", nativeQuery = true)
    List<UserAbs> findUserByPlatform(@Param("platform")String platform);

    @Query(value ="SELECT * FROM user_table u WHERE u.type_user = :user_type", nativeQuery = true)
    List<UserAbs> findUserByTypeUser(@Param("user_type")String user_type);

    @Query(value ="SELECT * FROM user_table u WHERE u.nickname = :nickname", nativeQuery = true)
    UserAbs findUserByNickname(@Param("nickname")String nickname);



}
