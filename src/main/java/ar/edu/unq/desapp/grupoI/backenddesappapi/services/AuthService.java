package ar.edu.unq.desapp.grupoi.backenddesappapi.services;

import ar.edu.unq.desapp.grupoi.backenddesappapi.model.user.PlatformUser;

public interface AuthService {

    String createToken(PlatformUser user);

    PlatformUser validateUserToken(String token);

    PlatformUser registerUser(PlatformUser user);

    PlatformUser findUser(String nickname);
}