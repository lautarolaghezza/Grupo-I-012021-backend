package ar.edu.unq.desapp.grupoi.backenddesappapi.services;

import ar.edu.unq.desapp.grupoi.backenddesappapi.Utils.TokenProvider;
import ar.edu.unq.desapp.grupoi.backenddesappapi.exceptions.UserHasBeenAddedException;
import ar.edu.unq.desapp.grupoi.backenddesappapi.model.user.PlatformUser;
import ar.edu.unq.desapp.grupoi.backenddesappapi.services.userService.PlatformUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private PlatformUserService userService;

    TokenProvider tokenProvider = new TokenProvider();

    @Override
    public String createToken(PlatformUser user) {
        return tokenProvider.createToken(user);
    }

    @Override
    public PlatformUser validateUserToken(String token) {
        return userService.findBy(tokenProvider.getUserToken(token));
    }

    @Override
    public PlatformUser registerUser(PlatformUser user) {
        if(! userService.existsUser(user)){
            user.setPassword(tokenProvider.createToken(user));
            return userService.save(user);
        }else{
            throw new UserHasBeenAddedException();
        }
    }

    @Override
    public PlatformUser findUser(String nickname) {
        return userService.findBy(nickname);
    }

}
