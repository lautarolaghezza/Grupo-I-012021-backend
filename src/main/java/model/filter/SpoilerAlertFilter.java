package model.filter;

import model.reviews.PremiumReview;
import model.reviews.PublicReview;
import model.reviews.Review;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public final class SpoilerAlertFilter extends Filter{
    private boolean spoilerAlert;

    public SpoilerAlertFilter(boolean spoilerAlert) {
        this.spoilerAlert = spoilerAlert;
    }

    @Override
    public List<Review> doFilter(List<Review> reviews) {
        return reviews
                                .stream()
                                .filter( r -> ((PublicReview) r).isSpoiler_Alert()== spoilerAlert)
                                .collect(Collectors.toList());
    }
}
