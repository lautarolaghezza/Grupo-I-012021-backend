package ar.edu.unq.desapp.grupoi.backenddesappapi.services.userService;

import ar.edu.unq.desapp.grupoi.backenddesappapi.model.user.UserAbs;

import java.util.List;

public interface UserService {

    List<UserAbs> getUsers();
    UserAbs getUser(long user_id);
    void addUser(UserAbs userAbs);
}
