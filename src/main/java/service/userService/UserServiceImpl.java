package service.userService;

import model.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.user.UserRepositoryImpl;

import java.util.List;

@Service
public class UserServiceImpl  implements  UserService{

    @Autowired
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
