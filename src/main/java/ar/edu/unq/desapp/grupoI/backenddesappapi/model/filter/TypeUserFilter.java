package ar.edu.unq.desapp.grupoi.backenddesappapi.model.filter;

import ar.edu.unq.desapp.grupoi.backenddesappapi.model.reviews.Review;
import ar.edu.unq.desapp.grupoi.backenddesappapi.model.user.UserAbs;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public final class TypeUserFilter extends Filter{
    private String type_user;

    public TypeUserFilter(String type_user) {
        this.type_user = type_user;
        this.type = "type_user";
        this.value = type_user;
    }

    @Override
    public List<Review> doFilter(List<Review> reviews, List<UserAbs> userAbsList) {

        return reviews
                .stream()
                .filter( r -> userAbsList
                        .stream()
                        .filter(u -> u.getUser_id().equals(r.getUserAbs().getUser_id()))
                        .collect(Collectors.toList())
                        .get(0).getType_user().equalsIgnoreCase(this.type_user))
                .collect(Collectors.toList());
    }

}
