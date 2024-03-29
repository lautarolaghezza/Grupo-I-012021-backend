package ar.edu.unq.desapp.grupoi.backenddesappapi.Utils;

import ar.edu.unq.desapp.grupoi.backenddesappapi.exceptions.UnauthorizedException;
import ar.edu.unq.desapp.grupoi.backenddesappapi.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

public class BaseController {

    @Autowired
    protected AuthService authService;

    public void validateApiKey(String apikey) {
        try {
            authService.validateUserToken(apikey);
        } catch (Exception e) {
            throw new UnauthorizedException(HttpStatus.UNAUTHORIZED);
        }
    }

}
