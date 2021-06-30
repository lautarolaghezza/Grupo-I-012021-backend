package ar.edu.unq.desapp.grupoi.backenddesappapi.model.filter;

import ar.edu.unq.desapp.grupoi.backenddesappapi.model.reviews.Review;
import ar.edu.unq.desapp.grupoi.backenddesappapi.model.user.UserAbs;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public final class PlatformFilter extends  Filter{
    private String platform;

    public PlatformFilter(String platform) {
        this.platform = platform;
        this.type = "platform";
        this.value = platform;
    }

    @Override
    public List<Review> doFilter(List<Review> reviews, List<UserAbs> userAbsList) {
        return reviews
                .stream()
                .filter( r -> userAbsList
                                    .stream()
                                    .filter(u -> u.getUser_id().equals(r.getUserAbs().getUser_id()))
                                    .collect(Collectors.toList())
                                    .get(0).getPlatform().equalsIgnoreCase(this.platform))
                .collect(Collectors.toList());
    }

    public String getPlatform() {
        return platform;
    }
}
