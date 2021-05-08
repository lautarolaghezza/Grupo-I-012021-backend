package ar.edu.unq.desapp.grupoi.backenddesappapi.model.filter;

import ar.edu.unq.desapp.grupoi.backenddesappapi.model.platform.Platform;
import ar.edu.unq.desapp.grupoi.backenddesappapi.model.reviews.Review;
import java.util.List;
import java.util.stream.Collectors;


public final class PlatformFilter extends  Filter{
    private final Platform platform;

    public PlatformFilter(Platform platform) {
        this.platform = platform;
    }

    @Override
    public List<Review> doFilter(List<Review> reviews) {
        return reviews
                .stream()
                .filter( r -> r.getUserAbs().getPlatform() == this.platform)
                .collect(Collectors.toList());
    }

    public Platform getPlatform() {
        return platform;
    }
}
