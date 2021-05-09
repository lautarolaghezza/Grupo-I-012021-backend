package ar.edu.unq.desapp.grupoi.backenddesappapi.model.filter;

import ar.edu.unq.desapp.grupoi.backenddesappapi.model.reviews.Review;
import ar.edu.unq.desapp.grupoi.backenddesappapi.model.user.Type_User;
import ar.edu.unq.desapp.grupoi.backenddesappapi.model.user.UserAbs;

import java.util.List;
import java.util.stream.Collectors;


public final class TypeUserFilter extends Filter{
    private final Type_User type_user;

    public TypeUserFilter(String type_user) {
        this.type_user = Type_User.valueOf(type_user.toUpperCase());
    }

    @Override
    public List<Review> doFilter(List<Review> reviews, List<UserAbs> userAbsList) {
        return reviews
                .stream()
                .filter( r -> userAbsList
                        .stream()
                        .filter(u -> u.getId() == r.getUserId())
                        .collect(Collectors.toList())
                        .get(0).getType_user()== this.type_user)
                .collect(Collectors.toList());
    }

    public Type_User getType_user() {
        return type_user;
    }
}
