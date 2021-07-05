package ar.edu.unq.desapp.grupoi.backenddesappapi.services;

import ar.edu.unq.desapp.grupoi.backenddesappapi.Utils.TokenProvider;
import ar.edu.unq.desapp.grupoi.backenddesappapi.exceptions.UserHasBeenAddedException;
import ar.edu.unq.desapp.grupoi.backenddesappapi.model.user.PlatformUser;
import ar.edu.unq.desapp.grupoi.backenddesappapi.services.userService.PlatformUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

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
            throw new UserHasBeenAddedException(HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public PlatformUser findUser(String nickname) {
        return userService.findBy(nickname);
    }


    @Transactional
    @Override
    public PlatformUser setNotifyUrl(PlatformUser user) {
        PlatformUser userDB = userService.findBy(user.getNickname());
        userDB.setNotify_url(user.getNotify_url());
        return userService.save(userDB);
    }

}
