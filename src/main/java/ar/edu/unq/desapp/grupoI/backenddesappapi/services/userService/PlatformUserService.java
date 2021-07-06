package ar.edu.unq.desapp.grupoi.backenddesappapi.services.userService;

import ar.edu.unq.desapp.grupoi.backenddesappapi.exceptions.UserNotFoundException;
import ar.edu.unq.desapp.grupoi.backenddesappapi.model.user.PlatformUser;
import ar.edu.unq.desapp.grupoi.backenddesappapi.model.user.UserAbs;
import ar.edu.unq.desapp.grupoi.backenddesappapi.repositories.user.PlatformUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.xml.bind.SchemaOutputResolver;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
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

    public void notifyUsers(List<String> userNicks, String title) throws IOException {
        for (String nick : userNicks) {
            PlatformUser user = platformUserRepository.findById(nick).get();
            System.out.println("SE LE NOTIFICA AL USER "+nick +
                    "EN LA URL "+ user.getNotify_url() );
            /*HttpURLConnection httpClient =
                    (HttpURLConnection) new URL(user.getNotify_url()+"/"+title).openConnection();
            httpClient.setRequestMethod("POST");
            httpClient.getResponseMessage();*/
        }
    }
}
