package ar.edu.unq.desapp.grupoi.backenddesappapi.webservices;

import ar.edu.unq.desapp.grupoi.backenddesappapi.model.user.UserAbs;
import ar.edu.unq.desapp.grupoi.backenddesappapi.services.userService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@EnableAutoConfiguration
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping(value = "users")
    public List<UserAbs> getUsers(){ return userService.findAll();}

    @GetMapping(value = "users/location/{location}")
    public  List<UserAbs> getUsersByLocation(@PathVariable String location){
        return  userService.findUserByLocation(location);
    }
    @GetMapping(value = "users/typeuser/{typeuser}")
    public  List<UserAbs> getUsersByTypeUser(@PathVariable String typeuser){
        return  userService.findUserByTypeUser(typeuser);
    }
    @GetMapping(value = "users/platform/{platform}")
    public  List<UserAbs> getUsersByPlatform(@PathVariable String platform){
        return  userService.findUserByPlatform(platform);
    }
}
