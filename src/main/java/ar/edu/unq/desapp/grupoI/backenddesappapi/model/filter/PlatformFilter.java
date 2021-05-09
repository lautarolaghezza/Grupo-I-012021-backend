package ar.edu.unq.desapp.grupoi.backenddesappapi.model.filter;

import ar.edu.unq.desapp.grupoi.backenddesappapi.model.platform.Platform;
import ar.edu.unq.desapp.grupoi.backenddesappapi.model.reviews.Review;
import ar.edu.unq.desapp.grupoi.backenddesappapi.model.user.UserAbs;

import java.util.List;
import java.util.stream.Collectors;


public final class PlatformFilter extends  Filter{
    private final Platform platform;

    public PlatformFilter(String platform) {
        this.platform = Platform.valueOf(platform.toUpperCase());
    }

    @Override
    public List<Review> doFilter(List<Review> reviews, List<UserAbs> userAbsList) {
        return reviews
                .stream()
                .filter( r -> userAbsList
                                    .stream()
                                    .filter(u -> u.getId() == r.getUserId())
                                    .collect(Collectors.toList())
                                    .get(0).getPlatform() == this.platform)
                .collect(Collectors.toList());
    }

    public Platform getPlatform() {
        return platform;
    }
}
