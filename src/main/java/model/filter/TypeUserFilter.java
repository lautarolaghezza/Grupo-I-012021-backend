package model.filter;

import lombok.Getter;
import model.reviews.Review;
import model.user.Type_User;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public final class TypeUserFilter extends Filter{
    private final Type_User type_user;

    public TypeUserFilter(Type_User type_user) {
        this.type_user = type_user;
    }

    @Override
    public List<Review> doFilter(List<Review> reviews) {
        return reviews
                .stream()
                .filter( r -> r.getUser().getType_user()== type_user)
                .collect(Collectors.toList());
    }
}
