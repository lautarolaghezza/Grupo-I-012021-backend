package ar.edu.unq.desapp.grupoi.backenddesappapi.model.filter;

import ar.edu.unq.desapp.grupoi.backenddesappapi.model.reviews.Review;
import ar.edu.unq.desapp.grupoi.backenddesappapi.model.user.CommonUserAbs;


import java.util.List;
import java.util.stream.Collectors;

public final class LocationFilter extends Filter {

    private final String location;

    public LocationFilter(String location) {
        this.location = location;
    }

    @Override
    public List<Review> doFilter(List<Review> reviews) {
        return reviews
                .stream()
                .filter( r -> ((CommonUserAbs) r.getUser()).getLocation().equalsIgnoreCase(this.location))
                .collect(Collectors.toList());
    }

    public String getLocation() {
        return location;
    }
}
