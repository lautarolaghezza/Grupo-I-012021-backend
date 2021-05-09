package ar.edu.unq.desapp.grupoi.backenddesappapi.model.filter;

import ar.edu.unq.desapp.grupoi.backenddesappapi.model.reviews.PublicReview;
import ar.edu.unq.desapp.grupoi.backenddesappapi.model.reviews.Review;
import ar.edu.unq.desapp.grupoi.backenddesappapi.model.user.UserAbs;

import java.util.List;
import java.util.stream.Collectors;


public final class SpoilerAlertFilter extends Filter{

    private final boolean spoilerAlert;

    public SpoilerAlertFilter(boolean spoilerAlert) {
        this.spoilerAlert = spoilerAlert;
    }

    @Override
    public List<Review> doFilter(List<Review> reviews, List<UserAbs> userAbsList) {
        return reviews
                                .stream()
                                .filter( r -> ((PublicReview) r).isSpoiler_Alert()== this.spoilerAlert)
                                .collect(Collectors.toList());
    }

    public boolean isSpoilerAlert() {
        return spoilerAlert;
    }
}
