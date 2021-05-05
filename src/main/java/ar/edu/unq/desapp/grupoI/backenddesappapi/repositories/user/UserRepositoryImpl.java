package ar.edu.unq.desapp.grupoi.backenddesappapi.repositories.user;

import ar.edu.unq.desapp.grupoi.backenddesappapi.exceptions.UserHasBeenAddedException;
import ar.edu.unq.desapp.grupoi.backenddesappapi.exceptions.UserNotFoundException;
import ar.edu.unq.desapp.grupoi.backenddesappapi.model.user.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserRepositoryImpl implements UserRepository{

    List<User> users;

    public UserRepositoryImpl() {
        this.users = new ArrayList<>();
    }

    @Override
    public List<User> getUsers() {
        return this.users;
    }

    @Override
    public User getUser(long id) {
        Optional<User> user = users.stream()
                .filter(u -> u.getUserId() == id)
                .findFirst();
        return  user.orElseThrow(UserNotFoundException::new);
    }

    @Override
    public void addUser(User user) {
        boolean isAdded = this.users.stream().anyMatch(u -> u.getUserId() == user.getUserId());
        if (isAdded) throw new UserHasBeenAddedException();
        users.add(user);
    }
}
