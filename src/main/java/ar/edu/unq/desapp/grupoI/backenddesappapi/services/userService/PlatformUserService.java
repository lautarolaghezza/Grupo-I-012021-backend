package ar.edu.unq.desapp.grupoi.backenddesappapi.services.userService;

import ar.edu.unq.desapp.grupoi.backenddesappapi.exceptions.UserNotFoundException;
import ar.edu.unq.desapp.grupoi.backenddesappapi.model.user.PlatformUser;
import ar.edu.unq.desapp.grupoi.backenddesappapi.repositories.user.PlatformUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PlatformUserService {

    @Autowired
    private PlatformUserRepository platformUserRepository;

    public PlatformUser findBy(String nickname) {
        return platformUserRepository.findById(nickname).orElseThrow(() -> new UserNotFoundException(HttpStatus.BAD_REQUEST));
    }
    public PlatformUser save(PlatformUser user) {
        return platformUserRepository.save(user);
    }

    public boolean existsUser(PlatformUser user) {
        Optional<PlatformUser> userLoaded = platformUserRepository.findById(user.getNickname());
        PlatformUser userLoadedwithmail = platformUserRepository.findByMail(user.getMail());
        return userLoaded.isPresent() || userLoadedwithmail != null;
    }
}
