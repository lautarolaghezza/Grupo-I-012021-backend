package ar.edu.unq.desapp.grupoi.backenddesappapi.webservices;

import ar.edu.unq.desapp.grupoi.backenddesappapi.model.user.PlatformUser;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT})
public class AuthenticationController extends BaseController {

    @PostMapping("register")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<PlatformUser> register(@RequestBody PlatformUser user) {
        authService.registerUser(user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping("login")
    public String login(@RequestBody PlatformUser user) {
        PlatformUser userLoaded = authService.findUser(user.getNickname());
        System.out.println(userLoaded.getNickname());
        System.out.println(userLoaded.getPassword());
        String token = authService.createToken(user);
        System.out.println(token);
        System.out.println(userLoaded.getPassword().equals(token));
        return token;
    }


}




