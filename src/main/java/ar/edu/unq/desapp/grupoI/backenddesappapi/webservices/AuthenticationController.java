package ar.edu.unq.desapp.grupoi.backenddesappapi.webservices;

import ar.edu.unq.desapp.grupoi.backenddesappapi.exceptions.UserNotFoundException;
import ar.edu.unq.desapp.grupoi.backenddesappapi.model.user.PlatformUser;
import ar.edu.unq.desapp.grupoi.backenddesappapi.model.user.UserAbs;
import ar.edu.unq.desapp.grupoi.backenddesappapi.services.AuthServiceImpl;
import ar.edu.unq.desapp.grupoi.backenddesappapi.services.userService.PlatformUserService;
import ar.edu.unq.desapp.grupoi.backenddesappapi.services.userService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT})
public class AuthenticationController {

    @Autowired
    AuthServiceImpl authService;

    @PostMapping("register")
    @CrossOrigin(origins = "*")
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




