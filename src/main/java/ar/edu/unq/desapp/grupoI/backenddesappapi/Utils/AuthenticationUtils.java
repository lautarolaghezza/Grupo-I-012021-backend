package ar.edu.unq.desapp.grupoi.backenddesappapi.Utils;

import ar.edu.unq.desapp.grupoi.backenddesappapi.model.user.PlatformUser;
import ar.edu.unq.desapp.grupoi.backenddesappapi.model.user.UserAbs;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT})
public class AuthenticationUtils extends BaseController {

    @PostMapping("register")
    public ResponseEntity<PlatformUser> register(@RequestBody PlatformUser user) {
        authService.registerUser(user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping("login")
    public String login(@RequestBody PlatformUser user) {
        System.out.println(user.getNickname());
        PlatformUser userLoaded = authService.findUser(user.getNickname());
        System.out.println(userLoaded.getNickname());
        System.out.println(userLoaded.getPassword());
        String token = authService.createToken(user);
        System.out.println(token);
        System.out.println(userLoaded.getPassword());
        return token;
    }

    @PostMapping(value="users/notifyurl")
    public PlatformUser setNotifyUrl(@RequestHeader("api-key") String apiKey, @RequestBody PlatformUser user){
        validateApiKey(apiKey);
        return authService.setNotifyUrl(user);
    }


}




