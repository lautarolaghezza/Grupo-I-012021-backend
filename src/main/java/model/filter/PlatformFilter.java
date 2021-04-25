package model.filter;

import lombok.Getter;
import model.Platform;
import model.reviews.Review;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public final class PlatformFilter extends  Filter{
    private final Platform platform;

    public PlatformFilter(Platform platform) {
        this.platform = platform;
    }

    @Override
    public List<Review> doFilter(List<Review> reviews) {
        return reviews
                .stream()
                .filter( r -> r.getUser().getPlatform()== platform)
                .collect(Collectors.toList());
    }
}
