package ar.edu.unq.desapp.grupoi.backenddesappapi.model.filter;

import ar.edu.unq.desapp.grupoi.backenddesappapi.model.reviews.Review;
import ar.edu.unq.desapp.grupoi.backenddesappapi.model.user.Type_User;
import java.util.List;
import java.util.stream.Collectors;


public final class TypeUserFilter extends Filter{
    private final Type_User type_user;

    public TypeUserFilter(Type_User type_user) {
        this.type_user = type_user;
    }

    @Override
    public List<Review> doFilter(List<Review> reviews) {
        return reviews
                .stream()
                .filter( r -> r.getUser().getType_user()== this.type_user)
                .collect(Collectors.toList());
    }

    public Type_User getType_user() {
        return type_user;
    }
}
