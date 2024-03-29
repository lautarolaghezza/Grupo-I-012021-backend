package ar.edu.unq.desapp.grupoi.backenddesappapi.services.userService;

import ar.edu.unq.desapp.grupoi.backenddesappapi.exceptions.UserNotFoundException;
import ar.edu.unq.desapp.grupoi.backenddesappapi.model.user.UserAbs;
import ar.edu.unq.desapp.grupoi.backenddesappapi.repositories.user.UserRepository;
import com.sun.corba.se.impl.corba.RequestImpl;
import org.omg.CORBA.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import sun.net.www.http.HttpClient;

import javax.transaction.Transactional;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserAbs> findAll() {
        return userRepository.findAll();
    }

    public UserAbs findBy(long user_id) {
        UserAbs result = userRepository.findBy(user_id);
        if (result == null) {
            throw new UserNotFoundException(HttpStatus.BAD_REQUEST);
        }
        return result;
    }

    public List<UserAbs> findUserByLocation(String location) {
        return userRepository.findUserByLocation(location.toUpperCase());
    }

    public List<UserAbs> findUserByPlatform(String platform) {
        return userRepository.findUserByPlatform(platform.toUpperCase());
    }

    public List<UserAbs> findUserByTypeUser(String typeUser) {
        return userRepository.findUserByTypeUser(typeUser.toUpperCase());
    }

    public UserAbs findUserByNickname(String nickname) {
        return userRepository.findUserByNickname(nickname);
    }

    public UserAbs save(UserAbs userAbs) {
        return this.userRepository.save(userAbs);
    }


}
