package ar.edu.unq.desapp.grupoi.backenddesappapi.services.userService;

import ar.edu.unq.desapp.grupoi.backenddesappapi.model.user.UserAbs;
import ar.edu.unq.desapp.grupoi.backenddesappapi.repositories.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public List<UserAbs> findAll() {
        return userRepository.findAll();
    }

    public UserAbs findBy(long user_id) {return userRepository.findBy(user_id);}

    public List<UserAbs> findUserByLocation(String location){ return userRepository.findUserByLocation(location.toUpperCase());}

    public List<UserAbs> findUserByPlatform(String platform){ return userRepository.findUserByPlatform(platform.toUpperCase());}

    public List<UserAbs> findUserByTypeUser(String typeUser){ return userRepository.findUserByTypeUser(typeUser.toUpperCase());}

    public UserAbs save(UserAbs userAbs){ return this.userRepository.save(userAbs);}
}
