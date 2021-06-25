package ar.edu.unq.desapp.grupoi.backenddesappapi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;

public class NoSuchReviewsWithTitle extends ResponseStatusException {

    static String reason = "Review with this title could not be found";
    public NoSuchReviewsWithTitle(HttpStatus status) {
        super(status, reason);
        StackTraceElement[] stackTraceElements = new ArrayList<StackTraceElement>().toArray(new StackTraceElement[0]);
        super.setStackTrace(stackTraceElements);
    }
}
