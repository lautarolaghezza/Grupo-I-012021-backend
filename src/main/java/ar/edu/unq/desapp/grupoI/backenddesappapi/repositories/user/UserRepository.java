package ar.edu.unq.desapp.grupoi.backenddesappapi.repositories.user;

import ar.edu.unq.desapp.grupoi.backenddesappapi.model.user.UserAbs;

import java.util.List;
//@Configuration
//@Repository
public interface UserRepository {

    List<UserAbs> getUsers();

    UserAbs getUser(long id);

    void addUser(UserAbs userAbs);
}
