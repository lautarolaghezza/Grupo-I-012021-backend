package ar.edu.unq.desapp.grupoi.backenddesappapi.services.userService;

import ar.edu.unq.desapp.grupoi.backenddesappapi.model.user.UserAbs;
import ar.edu.unq.desapp.grupoi.backenddesappapi.repositories.user.UserRepositoryImpl;


import java.util.List;

//@Service
public class UserServiceImpl  implements  UserService{

    //@Autowired
    private UserRepositoryImpl userRepository;

    public UserServiceImpl() {
        this.userRepository = new UserRepositoryImpl();
    }

    @Override
    public List<UserAbs> getUsers() {
        return userRepository.getUsers();
    }

    @Override
    public UserAbs getUser(long user_id) {
        return userRepository.getUser(user_id);
    }

    @Override
    public void addUser(UserAbs userAbs) {
        userRepository.addUser(userAbs);
    }
}
