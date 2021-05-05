package ar.edu.unq.desapp.grupoi.backenddesappapi.services.userService;

import ar.edu.unq.desapp.grupoi.backenddesappapi.model.user.User;
import ar.edu.unq.desapp.grupoi.backenddesappapi.repositories.user.UserRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

//@Service
public class UserServiceImpl  implements  UserService{

    //@Autowired
    private UserRepositoryImpl userRepository;

    public UserServiceImpl() {
        this.userRepository = new UserRepositoryImpl();
    }

    @Override
    public List<User> getUsers() {
        return userRepository.getUsers();
    }

    @Override
    public User getUser(long user_id) {
        return userRepository.getUser(user_id);
    }

    @Override
    public void addUser(User user) {
        userRepository.addUser(user);
    }
}
