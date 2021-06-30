package ar.edu.unq.desapp.grupoi.backenddesappapi.model.filter;

import ar.edu.unq.desapp.grupoi.backenddesappapi.model.reviews.Review;
import ar.edu.unq.desapp.grupoi.backenddesappapi.model.user.UserAbs;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public final class LocationFilter extends Filter {

    private final String location;

    public LocationFilter(String location) {
        this.location = location.toUpperCase();
        this.type = "location";
        this.value = location;
    }

    @Override
    public List<Review> doFilter(List<Review> reviews, List<UserAbs> userAbsList) {
        return reviews
                .stream()
                .filter( r -> (userAbsList
                        .stream()
                        .filter(u -> u.getUser_id() == r.getUserAbs().getUser_id())
                        .collect(Collectors.toList())
                        .get(0)).getLocation().equalsIgnoreCase(this.location))
                .collect(Collectors.toList());
    }

    public String getLocation() {
        return location;
    }
}
