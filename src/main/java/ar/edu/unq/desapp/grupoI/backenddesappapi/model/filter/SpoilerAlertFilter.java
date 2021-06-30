package ar.edu.unq.desapp.grupoi.backenddesappapi.model.filter;

import ar.edu.unq.desapp.grupoi.backenddesappapi.model.reviews.PublicReview;
import ar.edu.unq.desapp.grupoi.backenddesappapi.model.reviews.Review;
import ar.edu.unq.desapp.grupoi.backenddesappapi.model.user.UserAbs;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public final class SpoilerAlertFilter extends Filter{

    private final boolean spoiler_alert;

    public SpoilerAlertFilter(boolean spoilerAlert) {
        this.spoiler_alert = spoilerAlert;
        this.type = "spoiler_alert";
        this.value =  spoiler_alert ? "true" : "false";
    }

    @Override
    public List<Review> doFilter(List<Review> reviews, List<UserAbs> userAbsList) {
        return reviews
                                .stream()
                                .filter( r -> r.isPublicReview() && ((PublicReview) r).isSpoiler_alert() == this.spoiler_alert)
                                .collect(Collectors.toList());
    }

    public boolean isSpoilerAlert() {
        return spoiler_alert;
    }
}
