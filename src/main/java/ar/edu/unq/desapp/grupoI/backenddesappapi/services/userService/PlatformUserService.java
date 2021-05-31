package ar.edu.unq.desapp.grupoi.backenddesappapi.services.userService;

import ar.edu.unq.desapp.grupoi.backenddesappapi.exceptions.UserNotFoundException;
import ar.edu.unq.desapp.grupoi.backenddesappapi.model.user.PlatformUser;
import ar.edu.unq.desapp.grupoi.backenddesappapi.repositories.user.PlatformUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlatformUserService {

    @Autowired
    private PlatformUserRepository platformUserRepository;

    public PlatformUser findBy(String nickname) {
        return platformUserRepository.findById(nickname).orElseThrow(UserNotFoundException::new);
    }

    public PlatformUser save(PlatformUser user) {
        return platformUserRepository.save(user);
    }
}
