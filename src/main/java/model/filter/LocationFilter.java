package model.filter;

import lombok.Getter;
import model.reviews.Review;
import model.user.CommonUser;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public final class LocationFilter extends Filter {

    private final String location;

    public LocationFilter(String location) {
        this.location = location;
    }

    @Override
    public List<Review> doFilter(List<Review> reviews) {
        return reviews
                .stream()
                .filter( r -> ((CommonUser) r.getUser()).getLocation().equalsIgnoreCase(this.location))
                .collect(Collectors.toList());
    }
}
