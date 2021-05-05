package ar.edu.unq.desapp.grupoi.backenddesappapi.services.userService;

import ar.edu.unq.desapp.grupoi.backenddesappapi.model.user.User;

import java.util.List;

public interface UserService {

    List<User> getUsers();
    User getUser(long user_id);
    void addUser(User user);
}
