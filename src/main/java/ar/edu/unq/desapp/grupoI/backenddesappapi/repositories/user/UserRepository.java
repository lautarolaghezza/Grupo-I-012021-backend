package ar.edu.unq.desapp.grupoi.backenddesappapi.repositories.user;

import ar.edu.unq.desapp.grupoi.backenddesappapi.model.user.User;

import java.util.List;
//@Configuration
//@Repository
public interface UserRepository {

    List<User> getUsers();

    User getUser(long id);

    void addUser(User user);
}
