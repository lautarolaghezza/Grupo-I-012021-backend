package repository.user;

import model.user.User;

import java.util.List;

public interface UserRepository {

    List<User> getUsers();

    User getUser(long id);

    void addUser(User user);
}
