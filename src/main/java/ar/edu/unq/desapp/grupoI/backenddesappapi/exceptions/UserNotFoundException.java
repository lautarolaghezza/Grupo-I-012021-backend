package ar.edu.unq.desapp.grupoi.backenddesappapi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;

public class UserNotFoundException extends ResponseStatusException {
    static String reason = "User could not be found";
    public UserNotFoundException(HttpStatus status) {
        super(status, reason);
        StackTraceElement[] stackTraceElements = new ArrayList<StackTraceElement>().toArray(new StackTraceElement[0]);
        super.setStackTrace(stackTraceElements);
    }
}
