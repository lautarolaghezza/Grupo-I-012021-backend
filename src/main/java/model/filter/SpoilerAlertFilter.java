package model.filter;

import lombok.Getter;
import model.reviews.PublicReview;
import model.reviews.Review;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public final class SpoilerAlertFilter extends Filter{

    private final boolean spoilerAlert;

    public SpoilerAlertFilter(boolean spoilerAlert) {
        this.spoilerAlert = spoilerAlert;
    }

    @Override
    public List<Review> doFilter(List<Review> reviews) {
        return reviews
                                .stream()
                                .filter( r -> ((PublicReview) r).isSpoiler_Alert()== this.spoilerAlert)
                                .collect(Collectors.toList());
    }
}
