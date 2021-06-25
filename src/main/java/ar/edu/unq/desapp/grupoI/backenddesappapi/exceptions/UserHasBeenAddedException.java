package ar.edu.unq.desapp.grupoi.backenddesappapi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;

public class UserHasBeenAddedException extends ResponseStatusException {
    static String reason = "User exists";
    public UserHasBeenAddedException(HttpStatus status) {
        super(status, reason);
        StackTraceElement[] stackTraceElements = new ArrayList<StackTraceElement>().toArray(new StackTraceElement[0]);
        super.setStackTrace(stackTraceElements);
    }
}
