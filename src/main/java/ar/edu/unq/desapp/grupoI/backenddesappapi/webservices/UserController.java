package ar.edu.unq.desapp.grupoi.backenddesappapi.webservices;

import ar.edu.unq.desapp.grupoi.backenddesappapi.Utils.BaseController;
import ar.edu.unq.desapp.grupoi.backenddesappapi.model.user.PlatformUser;
import ar.edu.unq.desapp.grupoi.backenddesappapi.model.user.UserAbs;
import ar.edu.unq.desapp.grupoi.backenddesappapi.services.userService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@EnableAutoConfiguration
public class UserController extends BaseController {
    @Autowired
    private UserService userService;

    @GetMapping(value = "users")
    public List<UserAbs> getUsers(@RequestHeader("api-key") String apiKey){
        validateApiKey(apiKey);
        return userService.findAll();}

    @GetMapping(value = "users/location/{location}")
    public  List<UserAbs> getUsersByLocation(@RequestHeader("api-key") String apiKey, @PathVariable String location){
        validateApiKey(apiKey);
        return  userService.findUserByLocation(location);
    }
    @GetMapping(value = "users/typeuser/{typeuser}")
    public  List<UserAbs> getUsersByTypeUser(@RequestHeader("api-key") String apiKey, @PathVariable String typeuser){
        validateApiKey(apiKey);
        return  userService.findUserByTypeUser(typeuser);
    }
    @GetMapping(value = "users/platform/{platform}")
    public  List<UserAbs> getUsersByPlatform(@RequestHeader("api-key") String apiKey, @PathVariable String platform){
        validateApiKey(apiKey);
        return  userService.findUserByPlatform(platform);
    }

}
